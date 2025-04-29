package com.example.Lombok.repository;

import com.example.Lombok.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDetails ,Integer> {
}
