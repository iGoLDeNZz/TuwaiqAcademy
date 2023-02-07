package com.example.day3_onetomany.Controller;

import com.example.day3_onetomany.Model.Teacher;
import com.example.day3_onetomany.Service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher was added.");
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer teacherId){
        teacherService.updateTeacher(teacherId,teacher);
        return ResponseEntity.status(200).body("Teacher updates");
    }

    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable Integer teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.status(200).body("Teacher deleted");
    }
}
