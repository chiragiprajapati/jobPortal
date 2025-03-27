package com.jobPortal.jobPortal.Service;

import com.jobPortal.jobPortal.Model.Users;
import com.jobPortal.jobPortal.Repository.UserRepository;
import com.jobPortal.jobPortal.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUserEmail(username).orElseThrow(() -> new UsernameNotFoundException("Could not found user"));
        return new CustomUserDetails(user);
    }
}
