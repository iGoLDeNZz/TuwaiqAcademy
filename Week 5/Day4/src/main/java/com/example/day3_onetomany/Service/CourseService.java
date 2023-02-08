package com.example.day3_onetomany.Service;

import com.example.day3_onetomany.Model.Course;
import com.example.day3_onetomany.Model.Student;
import com.example.day3_onetomany.Model.Teacher;
import com.example.day3_onetomany.Repository.CourseRepository;
import com.example.day3_onetomany.Util.APIException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CourseService {


    private CourseRepository courseRepository;
    private TeacherService teacherService;

    public CourseService(CourseRepository courseRepository,
                         TeacherService teacherService){
        this.courseRepository = courseRepository;
        this.teacherService = teacherService;
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseBy(Integer courseId){
        return courseRepository.findById(courseId).orElse(null);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer courseId, Course course){
        Course storedCourse = courseRepository.findById(courseId).orElse(null);

        if(storedCourse == null)
            throw new APIException("Course not found", 404);

        storedCourse.setName(course.getName());
        courseRepository.save(storedCourse);
    }

    public void deleteCourse(Integer courseId){
        Course course = courseRepository.findById(courseId).orElse(null);
        if(course == null)
            throw new APIException("Course not found", 404);

        courseRepository.deleteById(courseId);
    }

    public void assignCourseToTeacher(Integer courseId, Integer teacherId){
        Course course = courseRepository.findById(courseId).orElse(null);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if(course == null || teacher == null)
            throw new APIException("Course or Teacher were not found", 404);

        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public String getTeacherNameForCourse(Integer courseId){
        Course course = courseRepository.findById(courseId).orElse(null);
        if(course == null)
            throw new APIException("Course was not found", 404);

        if (course.getTeacher() == null)
            throw new APIException("Teacher for course: "+courseId+" was not found", 404);

        return course.getTeacher().getName();
    }

    public Set<Student> getStudentList(Integer courseId){
        Course course = courseRepository.findById(courseId).orElse(null);
        if(course == null)
            throw new APIException("Course was not found", 404);

        return course.getStudents();
    }
}
