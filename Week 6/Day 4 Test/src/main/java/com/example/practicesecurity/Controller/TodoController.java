package com.example.practicesecurity.Controller;

import com.example.practicesecurity.Repository.TodoReqpository;
import com.example.practicesecurity.Service.TodoService;
import com.example.practicesecurity.model.MyUser;
import com.example.practicesecurity.model.Todo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/get")
    public ResponseEntity getTodos(@AuthenticationPrincipal MyUser myUser){
        return ResponseEntity.status(200).body(todoService.getTodosByUserId(myUser.getId()));
    }

    @PostMapping("/add")
    public ResponseEntity addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        System.out.println(myUser);
        todoService.addTodo(myUser.getId(), todo);
        return ResponseEntity.status(200).body("todo was added!");
    }


}
