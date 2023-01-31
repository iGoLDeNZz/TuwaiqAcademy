package com.example.day_2.Controller;

import com.example.day_2.Model.User;
import com.example.day_2.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable Integer id, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
            return ResponseEntity.status(200).body("User update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body("User with id: "+id+" was delete.");
    }

    @GetMapping("/age")
    public ResponseEntity getUsersByAge(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.getUsersByAge(user));
    }

    @GetMapping("/auth")
    public ResponseEntity authUser(@RequestBody User user){
        userService.getUserByUsernameAndPassword(user);
        return ResponseEntity.status(200).body("Username and password are correct, welcome back.");
    }


    @GetMapping("/role")
    public ResponseEntity getUsersByRole(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.getUserByRole(user));
    }

    @GetMapping("/email")
    public ResponseEntity getUsersByEmail(@RequestBody User user){
        return ResponseEntity.status(200).body(userService.getUserByEmail(user));
    }
}

