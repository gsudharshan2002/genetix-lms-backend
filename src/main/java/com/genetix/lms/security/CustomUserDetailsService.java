package com.genetix.lms.security;

import com.genetix.lms.model.User;
import com.genetix.lms.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public CustomUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch user from database
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        // ✅ Eclipse-friendly: use ArrayList instead of Collections.singletonList()
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

        // Return Spring Security User object
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),      // Requires getEmail() in User
                user.getPassword(),   // Requires getPassword() in User
                authorities
        );
    }
}
