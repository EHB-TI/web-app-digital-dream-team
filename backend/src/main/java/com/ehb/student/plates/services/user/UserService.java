package com.ehb.student.plates.services.user;

import com.ehb.student.plates.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getUserById(Long id);

    Page<User> getUsers(Pageable pageable);

    void deleteUser(Long id);

}
