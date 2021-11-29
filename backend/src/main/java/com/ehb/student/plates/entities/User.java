package com.ehb.student.plates.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
public class User extends AbstractEntity implements UserDetails {

    @Column(name = "username", unique = true)
    private String username;

    @Getter
    @Column(name = "email", unique = true)
    private String email;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Embedded
    private Address address;

    @Column(name = "password")
    private String password;

    @Getter
    @Column(name = "reset_password")
    private String resetPassword;

    @Getter
    @Column(name = "email_validation")
    private String emailValidation;

    @Getter
    @Column(name = "login_attempts")
    private int loginAttempts;

    @Column(name = "account_enabled")
    private boolean accountEnabled = true;

    @Getter
    @OneToMany(mappedBy = "user")
    private List<PlateOrder> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return accountEnabled;
    }
}
