package com.example.practicesecurity.Repository;

import com.example.practicesecurity.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoReqpository extends JpaRepository<Todo, Integer> {

    List<Todo> findAllByUserId(Integer userId);
    Todo findTodoById(Integer id);
}
