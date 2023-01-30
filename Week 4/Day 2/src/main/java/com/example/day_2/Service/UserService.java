package com.example.day_2.Service;

import com.example.day_2.Model.User;
import com.example.day_2.Repostory.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id, User user){
        User oldUser = userRepository.findById(id).orElse(null);

        if (oldUser == null)
            return false;

        user.setId(id);
        userRepository.save(user);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User oldUser = userRepository.findById(id).orElse(null);

        if (oldUser == null)
            return false;

        userRepository.deleteById(id);
        return true;
    }
}
