package com.example.springmodelmapper.repository;

import com.example.springmodelmapper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
