package com.example.week6_day2_security.service;

import com.example.week6_day2_security.Exception.APIException;
import com.example.week6_day2_security.model.User;
import com.example.week6_day2_security.model.Role;
import com.example.week6_day2_security.model.User;
import com.example.week6_day2_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    //Only admin can use this endpoint
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    private User getUserById(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            throw new APIException("ID not found", 404);
        return user;
    }

    public User getUserById(User user,Integer id){
        User user1 = getUserById(id);

        if (user.getRole() == Role.ADMIN)
            return user1;
        if (user1.getId() != user.getId()) {
            throw new APIException("you are not authorized to view this user", 401);
        }
        return user1;
    }

    //Only admin can use this endpoint
    public void deleteUser(Integer id){
        User user = getUserById(id);
        userRepository.delete(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Wrong Username or Password");
        return user;
    }

    public void register(User user){
        user.setRole(Role.CUSTOMER);
        String hashed = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashed);
        userRepository.save(user);
    }







}
