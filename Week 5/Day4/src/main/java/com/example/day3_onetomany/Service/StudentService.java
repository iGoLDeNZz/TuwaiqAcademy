package com.example.day3_onetomany.Service;

import com.example.day3_onetomany.Model.Student;
import com.example.day3_onetomany.Model.Course;
import com.example.day3_onetomany.Repository.StudentRepository;
import com.example.day3_onetomany.Util.APIException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

    private StudentRepository studentRepository;
    private CourseService courseService;

    public StudentService(StudentRepository studentRepository,
                          CourseService courseService){
        this.studentRepository = studentRepository;
        this.courseService = courseService;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer studentId, Student student){
        Student storedStudent = studentRepository.findById(studentId).orElse(null);

        if(storedStudent == null)
            throw new APIException("Student not found", 404);

        storedStudent.setName(student.getName());
        studentRepository.save(storedStudent);
    }

    public void deleteStudent(Integer studentId){
        Student student = studentRepository.findById(studentId).orElse(null);
        if(student == null)
            throw new APIException("Student not found", 404);

        studentRepository.deleteById(studentId);
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId){
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseService.getCourseBy(courseId);

        if(student == null || course == null)
            throw new APIException("Student or Course were not found", 404);

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseService.addCourse(course);
    }

    public void unassignStudentFromCourse(Integer studentId, Integer courseId){
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseService.getCourseBy(courseId);

        if(student == null || course == null)
            throw new APIException("Student or Course were not found", 404);

        student.getCourses().remove(course);
        course.getStudents().remove(student);

        studentRepository.save(student);
        courseService.addCourse(course);
    }

    public void changeStudentMajor(Integer studentId, Student student){
        Student storedStudent = studentRepository.findById(studentId).orElse(null);
        if(storedStudent == null)
            throw new APIException("Student was not found", 404);


        for (Course course: storedStudent.getCourses()) {
            courseService.getStudentList(course.getId()).remove(storedStudent);
            courseService.addCourse(course);
        }
        storedStudent.setMajor(student.getMajor());

        studentRepository.save(storedStudent);
    }


}
