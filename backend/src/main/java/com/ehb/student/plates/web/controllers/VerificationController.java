package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.services.verification.VerificationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping(path = "verification/{token}")
    public void activateUserByToken(@PathVariable String token) {
        verificationService.activateUserByToken(token);
    }

    @PostMapping(path = "verification/resend/{username}")
    public void resendVerificationToken(@PathVariable String username) throws MessagingException, IOException, URISyntaxException {
        verificationService.resendVerificationMail(username);
    }
}
