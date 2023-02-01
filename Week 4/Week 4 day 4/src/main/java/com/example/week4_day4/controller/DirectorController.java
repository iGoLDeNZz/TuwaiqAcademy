package com.example.week4_day4.controller;

import com.example.week4_day4.Service.DirectorService;
import com.example.week4_day4.model.Director;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/director")
public class DirectorController {

    private DirectorService directorService;

    public DirectorController(DirectorService directorService){
        this.directorService = directorService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllDirectors(){
        return ResponseEntity.status(200).body(directorService.getAllDirectors());
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@RequestBody @Valid Director director, @PathVariable Integer id, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body("Director update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body("Director with id: "+id+" was delete.");
    }
}
