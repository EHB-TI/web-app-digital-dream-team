package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.services.request.AbstractRequestMapperService;
import com.ehb.student.plates.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AbstractRequestMapperService requestMapper;
    private final UserService userService;

    @Autowired
    public UserController(AbstractRequestMapperService requestMapper, UserService userService) {
        this.requestMapper = requestMapper;
        this.userService = userService;
    }
}
