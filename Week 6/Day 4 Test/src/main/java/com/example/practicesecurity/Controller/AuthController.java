package com.example.practicesecurity.Controller;

import com.example.practicesecurity.DTO.Response;
import com.example.practicesecurity.Service.AuthService;
import com.example.practicesecurity.model.MyUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
     this.authService = authService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<MyUser>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(authService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody MyUser myUser){
        authService.register(myUser);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("registered", 201));
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("logged in", 201));
    }

    @PostMapping("/logout")
    public ResponseEntity<Response> logout(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("logged out", 201));
    }

    @PutMapping("/admin")
    public ResponseEntity admin(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("welcome admin", 201));
    }

    @PutMapping("/user")
    public ResponseEntity user(){
        return ResponseEntity.status(HttpStatus.OK).body(new Response("welcome user", 201));
    }

}
