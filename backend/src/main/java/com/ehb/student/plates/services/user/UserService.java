package com.ehb.student.plates.services.user;

import com.ehb.student.plates.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getUserById(Long id);

    Page<User> getUsers(Pageable pageable);
}
