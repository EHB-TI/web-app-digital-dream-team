package com.ehb.student.plates.events.listeners;

import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.entities.VerificationToken;
import com.ehb.student.plates.events.OnUserRegisteredEvent;
import com.ehb.student.plates.services.verification.VerificationService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationListener implements ApplicationListener<OnUserRegisteredEvent> {

    private final VerificationService verificationService;

    @Autowired
    public UserRegistrationListener(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(OnUserRegisteredEvent event) {
        VerificationToken verificationToken = verificationService.createVerificationTokenForUser((User) event.getSource());
        verificationService.sendVerificationMail(verificationToken);
    }
}
