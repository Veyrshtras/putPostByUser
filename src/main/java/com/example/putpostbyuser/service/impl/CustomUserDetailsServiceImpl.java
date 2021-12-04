package com.example.putpostbyuser.service.impl;

import com.example.putpostbyuser.dto.CustomUserDetails;
import com.example.putpostbyuser.entity.User;
import com.example.putpostbyuser.repository.UserRepository;
import com.example.putpostbyuser.service.CustomUserDetailService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.client.ClientDetailsUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailService {

    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user=userRepository.findByEmail(username);

//        if(user.isPresent()){
//            return new CustomUserDetails(user.get());
//        }
//        else
//            return null;

        return user.map(CustomUserDetails::new)
                .orElse(null);
    }
}
