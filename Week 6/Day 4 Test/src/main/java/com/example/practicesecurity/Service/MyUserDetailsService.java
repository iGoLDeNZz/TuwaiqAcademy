package com.example.practicesecurity.Service;

import com.example.practicesecurity.Repository.MyUserRepository;
import com.example.practicesecurity.model.MyUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final AuthService authService;

    public MyUserDetailsService(AuthService authService){
        this.authService = authService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = authService.getUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Wrong username or password");
        return user;
    }

}
