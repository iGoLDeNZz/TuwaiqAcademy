package com.example.day3_onetomany.Controller;

import com.example.day3_onetomany.Model.Course;
import com.example.day3_onetomany.Service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/get")
    public ResponseEntity getCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("Course was added.");
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity updateCourse(@RequestBody @Valid Course course, @PathVariable Integer courseId){
        courseService.updateCourse(courseId,course);
        return ResponseEntity.status(200).body("Course updates");
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable Integer courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.status(200).body("Course deleted");
    }

    @PutMapping("/assign/{courseId}/teacher/{teacherId}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer courseId, @PathVariable Integer teacherId){
        courseService.assignCourseToTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body("Teacher with id: "+teacherId+", was assigned to course: "+courseId);
    }
}