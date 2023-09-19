package com.budget.security.service;

import com.budget.entity.User;
import com.budget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }

        User user1 = user.get();


        return org.springframework.security.core.userdetails.User
                .builder()
                .username(user1.getEmail())
                .password(user1.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .disabled(false)
                .build();
    }
}
