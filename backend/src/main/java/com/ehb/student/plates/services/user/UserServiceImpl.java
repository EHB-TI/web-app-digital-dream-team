package com.ehb.student.plates.services.user;

import com.ehb.student.plates.entities.User;
import com.ehb.student.plates.repositories.UserRepository;
import com.ehb.student.plates.exceptions.EntityNotFoundException;
import com.ehb.student.plates.exceptions.UnauthorizedActionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.security.Principal;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void activateUser(User user) {
        user.setAccountEnabled(true);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    private boolean isUsernameDifferentFromLoggedInUser(String username) {
        String authUsername = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return !username.equals(authUsername);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(User.class, id));

        if (isUsernameDifferentFromLoggedInUser(user.getUsername())) {
            throw new UnauthorizedActionException("Cannot delete another user's account");
        }

        userRepository.deleteById(id);
    }
}
