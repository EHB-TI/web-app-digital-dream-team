package com.ehb.student.plates.services.auth;

import com.ehb.student.plates.entities.User;

public interface AuthenticationService {

    User registerUser(User user);

    User getLoggedInUser();
}
