package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.services.auth.AuthenticationService;
import com.ehb.student.plates.services.request.AbstractRequestMapperService;
import com.ehb.student.plates.web.dto.UserDTO;
import com.ehb.student.plates.web.requests.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class AuthenticationController {

    private final AuthenticationService authService;
    private final AbstractRequestMapperService requestMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authService, AbstractRequestMapperService requestMapper) {
        this.authService = authService;
        this.requestMapper = requestMapper;
    }

    @PostMapping(path = "/auth/register")
    public UserDTO registerUser(@Valid @RequestBody CreateUserRequest request) {
        User user = requestMapper.basicMap(request, User.class);
        return requestMapper.basicMap(authService.registerUser(user), UserDTO.class);
    }
}
