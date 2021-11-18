package com.ehb.student.plates.services.auth;

import com.ehb.student.plates.entities.User;

public interface AuthenticationService {

    String doAuthentication(String username, String password);

    User registerUser(User user);
}
