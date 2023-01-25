package com.example.week3_day4__validation.controllers;

import com.example.week3_day4__validation.APIResponse;
import com.example.week3_day4__validation.model.Employee;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();


    @GetMapping("/get")
    public ResponseEntity getAllEmployees(){
        return ResponseEntity.status(200).body(employees);
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new APIResponse("Employee: "+employee.getName()+" was added"));
    }

    @PutMapping("update/{index}")
    public ResponseEntity updateEmployee(@RequestBody @Valid Employee employee, @PathVariable int index, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new APIResponse(message));
        }
        if (index >= employees.size())
            return ResponseEntity.status(400).body(new APIResponse("Employee was not found"));

        employees.set(index, employee);
        return ResponseEntity.status(200).body(new APIResponse("Employee: "+employee.getName()+" was added"));
    }


    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index) {

        if (index >= employees.size())
            return ResponseEntity.status(400).body(new APIResponse("Employee was not found"));

        Employee tobeDeleted = employees.get(index);
        employees.remove(index);

        return ResponseEntity.status(200).body(new APIResponse("Employee: "+tobeDeleted.getName()+" was deleted"));
    }

    @PutMapping("/leave/{id}")
    public ResponseEntity applyForLeave(@PathVariable String id){

        for(Employee employee: employees){
            if(employee.getId().equals(id)){
                if (!employee.isOnLeave()){
                    if (employee.getAnnualLeave() >= 1){
                        employee.setAnnualLeave(employee.getAnnualLeave() - 1);
                        employee.setOnLeave(true);
                        return ResponseEntity.status(200).body(new APIResponse("Employee is: "+employee.getName()+" is now on leave"));
                    }
                } else
                    return ResponseEntity.status(400).body(new APIResponse("Employee is already on leave"));
            }
        }
        return ResponseEntity.status(400).body(new APIResponse("Employee with id: "+id+" was not found"));
    }


}

