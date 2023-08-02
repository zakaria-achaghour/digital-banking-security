package com.zakaria.digitalbanking.services;

import com.zakaria.digitalbanking.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private AppAcocountService appAcocountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser  appUser =  appAcocountService.loadUserByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException(String.format("User %s not found" , username));
        String[] roles = appUser.getRoles().stream().map(r -> r.getName()).toArray(String[]::new);
        UserDetails userDetails = User.withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles).build();
        return userDetails;
    }
}
