package com.example.day_2.Repostory;

import com.example.day_2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUsernameAndPassword(String username, String password);
    User findUserByEmail(String email);
    List<User> findUsersByRole(String role);
    @Query("select user from User user where user.age >= ?1")
    List<User> findUsersByAgeWhere(Integer age);
}
