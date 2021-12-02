package com.ehb.student.plates.web.controllers;

import com.ehb.student.plates.services.request.AbstractRequestMapperService;
import com.ehb.student.plates.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserController {

    private final AbstractRequestMapperService requestMapper;
    private final UserService userService;

    @Autowired
    public UserController(AbstractRequestMapperService requestMapper, UserService userService) {
        this.requestMapper = requestMapper;
        this.userService = userService;
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping(path = "users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
