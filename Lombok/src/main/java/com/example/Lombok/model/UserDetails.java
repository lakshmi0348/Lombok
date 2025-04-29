package com.example.Lombok.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private String name;
    private String job;
    private LocalDateTime createdBy;
    @Id
    private Integer id;

}
