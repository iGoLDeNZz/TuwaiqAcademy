package com.example.practicesecurity.Service;

import com.example.practicesecurity.Repository.TodoReqpository;
import com.example.practicesecurity.model.MyUser;
import com.example.practicesecurity.model.Todo;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private TodoReqpository todoReqpository;
    private AuthService authService;


    public List<Todo> getTodos(){
        return todoReqpository.findAll();
    }

    public List<Todo> getTodosByUserId(Integer id){
        return todoReqpository.findAllByUserId(id);
    }

    public Todo findTodoById(Integer todoId){
        Todo todo = todoReqpository.findTodoById(todoId);
        if ( todo == null)
            throw new RuntimeException("Todo not found");
        return todo;
    }

    public void addTodo(Integer id, Todo todo){
        MyUser user = authService.findMyUserById(id);
        todo.setUser(user);
        todoReqpository.save(todo);
    }

    public void updateTodo(Integer userId, Integer todoId, Todo todo){
        Todo oldTodo = findTodoById(todoId);

        if (oldTodo.getUser().getId() != userId)
            throw new RuntimeException("You don't have access to this todo");

        oldTodo.setTitle(todo.getTitle());
        todoReqpository.save(oldTodo);
    }

    public void deleteTodo(Integer userId, Integer todoId){
        Todo oldTodo = findTodoById(todoId);

        if (oldTodo.getUser().getId() != userId)
            throw new RuntimeException("You don't have access to this todo");

        todoReqpository.delete(oldTodo);
    }


}
