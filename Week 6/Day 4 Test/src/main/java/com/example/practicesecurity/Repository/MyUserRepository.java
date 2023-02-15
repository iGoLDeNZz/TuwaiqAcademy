package com.example.practicesecurity.Repository;

import com.example.practicesecurity.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
    MyUser findMyUserById(Integer id);
}
