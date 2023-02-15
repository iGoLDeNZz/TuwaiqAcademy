package com.example.practicesecurity.Service;

import com.example.practicesecurity.Repository.MyUserRepository;
import com.example.practicesecurity.model.MyUser;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private final MyUserRepository myUserRepository;

    public AuthService(MyUserRepository myUserRepository){
        this.myUserRepository = myUserRepository;
    }

    public List<MyUser> getAllUsers(){
        return myUserRepository.findAll();
    }

    public MyUser getUserByUsername(String username){
        return myUserRepository.findByUsername(username);
    }

    public void register(MyUser myUser) {
        myUser.setRole("USER");
        String hashedPass = new  BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setPassword(hashedPass);
        myUserRepository.save(myUser);
    }

    public MyUser findMyUserById(Integer userId){
        MyUser user = myUserRepository.findById(userId).orElse(null);

        if (user == null)
            throw new RuntimeException("User not found");

        return user;
    }
}
