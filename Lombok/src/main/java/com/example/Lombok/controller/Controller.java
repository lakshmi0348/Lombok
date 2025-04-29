package com.example.Lombok.controller;

import com.example.Lombok.model.Student;
import com.example.Lombok.model.UserDetails;
import com.example.Lombok.model.UserResponse;
import com.example.Lombok.service.FetchService;
import com.example.Lombok.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller
{
   @Autowired
   private StudentService studentService;
   @Autowired
   private FetchService fetchService;
   @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getMethod()
   {
       return ResponseEntity.ok(studentService.getAllStudents());
   }
   @GetMapping("/FetchUsersByApi")
   public List<UserDetails> getUserByApi()
   {
       return fetchService.getUserByApi();
   }
   @GetMapping("/FetchUserByApiId/{id}")
   public List<UserDetails> getUserApiId(@PathVariable Integer id)
   {
    return fetchService.getUserByApiId(id);
   }
   @GetMapping("/listOfUsers")
   public List<UserDetails> listOfUsers()
   {
       return fetchService.listUsers();
   }
   @GetMapping("/delayUser")
   public String delayUser()
   {
       return fetchService.delayUser();
   }
   @PostMapping("/SaveUsers")
   public List<UserDetails> saveUser()
   {
       return fetchService.postUser();
   }
   @PutMapping("/updateStudents/{student_id}")
    public ResponseEntity<Student> putMethod(@PathVariable Integer student_id, @RequestBody Student student)
   {
       return ResponseEntity.ok(studentService.updateStudentById(student_id,student));
   }
   @DeleteMapping("/deleteStudent/{student_id}")
    public ResponseEntity<Void> deleteMethod(@PathVariable Integer student_id)
   {
       studentService.deleteStudentById(student_id);
       return ResponseEntity.noContent().build();
   }
   @GetMapping("/GetStudentByid/{student_id}")
    public ResponseEntity<Object> GetIdMethod(@PathVariable Integer student_id)
   {
       return ResponseEntity.ok(studentService.getStudentById(student_id));
   }
   @PostMapping("/saveStudents")
    public ResponseEntity<Object> saveStudentMethod(@RequestBody Student student)
   {
       return ResponseEntity.ok(studentService.saveStudents(student));
   }
}
