package com.example.day3_onetomany.Service;

import com.example.day3_onetomany.Model.Teacher;
import com.example.day3_onetomany.Repository.TeacherRepository;
import com.example.day3_onetomany.Util.APIException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    private TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Integer teacherId){
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher == null)
            throw new APIException("Teacher was not found", 404);
        return teacher;
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer teacherId, Teacher teacher){
        Teacher storedTeacher = getTeacherById(teacherId);

        storedTeacher.setAge(teacher.getAge());
        storedTeacher.setName(teacher.getName());
        storedTeacher.setEmail(teacher.getEmail());
        storedTeacher.setSalary(teacher.getSalary());
        storedTeacher.setAddress(teacher.getAddress());
        teacherRepository.save(storedTeacher);
    }

    public void deleteTeacher(Integer teacherId){
        //This checks if teacher exists
        getTeacherById(teacherId);
        teacherRepository.deleteById(teacherId);
    }


}
