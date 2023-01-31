package com.example.day_2.Service;

import com.example.day_2.Model.User;
import com.example.day_2.Repostory.UserRepository;
import com.example.day_2.Utility.APIException;
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

    public void updateUser(Integer id, User user){
        User oldUser = userRepository.findById(id).orElse(null);

        if (oldUser == null)
            throw new APIException("User with id: "+id+" was not found.");

        user.setId(id);
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User oldUser = userRepository.findById(id).orElse(null);

        if (oldUser == null)
            throw new APIException("User with id: "+id+" was not found.");
        userRepository.deleteById(id);
    }

    public List<User> getUsersByAge(User user){
        if (user.getAge() == null)
            throw new APIException("Age is required");
        return userRepository.findUsersByAgeWhere(user.getAge());
    }

    public void getUserByUsernameAndPassword(User user){

        if (user.getUsername() == null || user.getPassword() == null)
            throw new APIException("Both Username and password are required");

        User fetched = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (fetched == null)
            throw new APIException("Username or password is incorrect");
    }

    public List<User> getUserByRole(User user){
        if (user.getRole() == null)
            throw new APIException("Role is required");

        return userRepository.findUsersByRole(user.getRole());
    }

    public User getUserByEmail(User user){
        if (user.getEmail() == null)
            throw new APIException("Email is required");
        return userRepository.findUserByEmail(user.getEmail());
    }
}
