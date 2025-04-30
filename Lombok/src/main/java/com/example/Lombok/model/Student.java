package com.example.Lombok.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "findName" , query = "Select s.student_name from Student s")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer student_id;
    @JsonProperty("student_name")
    private String student_name;
    @JsonProperty("student_address")
    private String student_address;


}
