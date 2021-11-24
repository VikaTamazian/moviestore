package com.trainee.moviestore.config.security;

import com.trainee.moviestore.exception.MoviestoreServiceException;
import com.trainee.moviestore.model.User;
import com.trainee.moviestore.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MvsUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public MvsUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userRepository.findByUsername(username) != null) {
            User user = userRepository.findByUsername(username);
            MvsUser mvsUser = new MvsUser(user);
            return (UserDetails) mvsUser;
        } else {
            return (UserDetails) new MoviestoreServiceException(String.format("User with id: %s not exist", username));

        }
    }
}
