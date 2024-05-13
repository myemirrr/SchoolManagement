package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email);

    int countAllByRole(String role);

    List<User> findByRoleAndEmailNotOrderByIdDesc(String role, String email);
}