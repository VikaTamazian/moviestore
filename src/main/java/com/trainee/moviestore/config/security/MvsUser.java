package com.trainee.moviestore.config.security;

import com.trainee.moviestore.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MvsUser {

    private User user;

    public MvsUser(User user) {
        this.user = user;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.user.getRoles().forEach(role -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role);
            authorities.add(grantedAuthority);
        });
        return authorities;
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public String getUsername() {
        return this.user.getUsername();
    }


}
