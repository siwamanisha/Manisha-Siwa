package org.texascsit.roomfindersystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.texascsit.roomfindersystem.exception.ResourceNotFoundException;
import org.texascsit.roomfindersystem.repo.RenterRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private RenterRepo renterRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return renterRepo.findByUsername(username)
        .orElseThrow (()-> new ResourceNotFoundException("User not found"));
    }
}
