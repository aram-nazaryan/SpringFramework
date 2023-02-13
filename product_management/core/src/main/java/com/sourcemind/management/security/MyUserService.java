package com.sourcemind.management.security;

import com.sourcemind.users.ImMemoryUsers;
import com.sourcemind.users.MyUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class MyUserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final List<MyUser> imMemoryUsers;

    public MyUserService(final PasswordEncoder passwordEncoder, ImMemoryUsers imMemoryUsers) {
        this.passwordEncoder = passwordEncoder;
        this.imMemoryUsers = imMemoryUsers.getUsers();
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        for (MyUser imMemoryUser : imMemoryUsers) {
            if (imMemoryUser.getUsername().equals(username)) {
                return new User(
                        imMemoryUser.getUsername(),
                        passwordEncoder.encode(imMemoryUser.getPassword()),
                        Collections.singletonList(new SimpleGrantedAuthority(imMemoryUser.getRole().toString()))
                );
            }
        }
        throw new UsernameNotFoundException("User not found");
    }
}
