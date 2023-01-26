package com.example.week_3_project.controller;


import com.example.week_3_project.model.User;
import com.example.week_3_project.service.UserService;
import com.example.week_3_project.utility.ServiceResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User: "+user.getUsername()+" was added.");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user, @PathVariable String id, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        ServiceResponse result = userService.updateUser(user, id);
        return ResponseEntity.status(result.getStatus()).body(result.getMessage());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        ServiceResponse result = userService.deleteUser(id);

        return ResponseEntity.status(result.getStatus()).body(result.getMessage());
    }

    @PutMapping("/stock/add/{merchantId}/{productId}/{stock}")
    public ResponseEntity addStock(@PathVariable String merchantId, @PathVariable String productId, @PathVariable int stock){
        ServiceResponse result = userService.addStock(productId,merchantId, stock);
        return ResponseEntity.status(result.getStatus()).body(result.getMessage());
    }

    @PutMapping("/buy/{userId}/{merchantId}/{productId}/{quantity}")
    public ResponseEntity buy(@PathVariable String userId, @PathVariable String merchantId, @PathVariable String productId, @PathVariable int quantity){
        ServiceResponse result = userService.buy(userId, productId,merchantId, quantity);
        return ResponseEntity.status(result.getStatus()).body(result.getMessage());
    }
}
