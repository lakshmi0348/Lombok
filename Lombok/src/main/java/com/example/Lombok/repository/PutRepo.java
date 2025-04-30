package com.example.Lombok.repository;

import com.example.Lombok.model.PutResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PutRepo  extends JpaRepository<PutResponse,Integer> {
}
