package com.ehb.student.plates.services.auth;

import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.events.OnUserRegisteredEvent;
import com.ehb.student.plates.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository,
                                     BCryptPasswordEncoder bCryptPasswordEncoder,
                                     ApplicationEventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public User registerUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        eventPublisher.publishEvent(new OnUserRegisteredEvent(user));
        return user;
    }

    @Override
    public User getLoggedInUser() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(username);
    }
}
