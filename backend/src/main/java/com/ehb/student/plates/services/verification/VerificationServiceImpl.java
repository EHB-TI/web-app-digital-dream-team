package com.ehb.student.plates.services.verification;

import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.entities.VerificationToken;
import com.ehb.student.plates.exceptions.EntityNotFoundException;
import com.ehb.student.plates.exceptions.VerificationTokenInvalidException;
import com.ehb.student.plates.repositories.VerificationRepository;
import com.ehb.student.plates.services.user.UserService;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class VerificationServiceImpl implements VerificationService {

    private final VerificationRepository verificationRepository;
    private final UserService userService;
    private final JavaMailSender mailSender;
    private static final String mailTemplatePath = "templates\\email\\verification\\verification-email.html";

    @Autowired
    public VerificationServiceImpl(VerificationRepository verificationRepository,
                                   UserService userService,
                                   JavaMailSender mailSender) {
        this.verificationRepository = verificationRepository;
        this.userService = userService;
        this.mailSender = mailSender;
    }

    @Override
    public VerificationToken activateUserByToken(String token) {
        VerificationToken verificationToken = verificationRepository.findVerificationTokenByToken(token)
                .orElseThrow(() -> new EntityNotFoundException(VerificationToken.class, token));

        if (verificationToken.isUsed()) {
            throw new VerificationTokenInvalidException("This verification token has already been used.");
        }

        if (verificationToken.getExpirationDate().isBefore(LocalDateTime.now())) {
            throw new VerificationTokenInvalidException("This verification token has expired. Please request a new one.");
        }

        userService.activateUser(verificationToken.getUser());
        verificationToken.setUsed(true);
        verificationRepository.save(verificationToken);
        return verificationToken;
    }

    @Override
    public VerificationToken createVerificationTokenForUser(User user) {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(UUID.randomUUID().toString());
        verificationToken.setUser(user);
        verificationToken.setExpirationDate(LocalDateTime.now().plusMinutes(VerificationToken.EXPIRATION));
        return verificationRepository.save(verificationToken);
    }

    @Override
    public void sendVerificationMail(VerificationToken token) throws MessagingException, IOException, URISyntaxException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, false);
        User user = token.getUser();
        helper.setFrom("info@digitaldreamteam.be");
        helper.setTo(token.getUser().getEmail());
        helper.setSubject("Your Share-Plate Verification Code");
        helper.setText(getFormattedMailTemplate(user.getFirstName(), token.getToken()), true);
        mailSender.send(message);
    }

    @Override
    public void resendVerificationMail(String username) throws MessagingException, IOException, URISyntaxException {
        User user = (User) userService.loadUserByUsername(username);
        if (user == null) {
            throw new EntityNotFoundException(User.class, username);
        }

        VerificationToken verificationToken = createVerificationTokenForUser(user);
        sendVerificationMail(verificationToken);
    }

    private String getFormattedMailTemplate(String name, String token) throws IOException, URISyntaxException {
        Map<String, String> values = new HashMap<String, String>() {{
            put("name", name);
            put("token", token);
            put("expiration_time", String.valueOf(VerificationToken.EXPIRATION));
        }};

        return StringSubstitutor.replace(getMailTemplate(), values, "{{", "}}");
    }

    private String getMailTemplate() throws IOException, URISyntaxException {
        return new String(
                Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(mailTemplatePath).toURI())),
                StandardCharsets.UTF_8
        );
    }
}
