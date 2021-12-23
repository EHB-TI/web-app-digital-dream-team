package com.ehb.student.plates.services.verification;

import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.entities.VerificationToken;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;

public interface VerificationService {

    VerificationToken activateUserByToken(String token);

    VerificationToken createVerificationTokenForUser(User user);

    void sendVerificationMail(VerificationToken token) throws MessagingException, IOException, URISyntaxException;

    void resendVerificationMail(String username) throws MessagingException, IOException, URISyntaxException;
}
