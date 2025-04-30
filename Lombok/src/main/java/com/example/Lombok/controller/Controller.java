package com.example.Lombok.controller;

import com.example.Lombok.model.*;
import com.example.Lombok.service.FetchService;
import com.example.Lombok.service.StudentService;
import com.example.Lombok.service.WithoutClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class Controller
{
   @Autowired
   private StudentService studentService;
   @Autowired
   private WithoutClass withoutClass;
   @Autowired
   private FetchService fetchService;



        @GetMapping("/allStudents")
        public ResponseEntity<List<Student>> getMethod ()
        {
            return ResponseEntity.ok(studentService.getAllStudents());
        }
        @GetMapping("/FetchUsersByApi")
        public ListUsersResponse getUserByApi ()
        {
            return fetchService.getUserByApi();
        }
        @GetMapping("/FetchUserByApiId/{id}")
        public UserResponseForSingle getUserApiId (@PathVariable Integer id)
        {
            return fetchService.getUserByApiId(id);
        }
        @GetMapping("/listOfUsers")
        public ListUsersResponse listOfUsers ()
        {
            return fetchService.listUsers();
        }
        @GetMapping("/delayUser")
        public List<UserDetails> delayUser ()
        {
            return fetchService.delayUser();
        }
        @PutMapping("/putUser")
        public List<UserDetails> putUser ()
        {
            return fetchService.putUser();
        }
        @PatchMapping("/patchUser")
        public List<UserDetails> patchUser ()
        {
            return fetchService.patchUser();
        }
        @DeleteMapping("/deleteUser")
        public void deleteUser ()
        {
            fetchService.deleteUser();
        }

        @PostMapping("/SaveUsers")
        public PutResponse saveUser (@RequestBody PutResponse putResponse)
        {
            return fetchService.postUser(putResponse);
        }
        @PutMapping("/updateStudents/{student_id}")
        public ResponseEntity<Student> putMethod (@PathVariable Integer student_id, @RequestBody Student student)
        {
            return ResponseEntity.ok(studentService.updateStudentById(student_id, student));
        }
        @DeleteMapping("/deleteStudent/{student_id}")
        public ResponseEntity<Void> deleteMethod (@PathVariable Integer student_id)
        {
            studentService.deleteStudentById(student_id);
            return ResponseEntity.noContent().build();
        }
        @GetMapping("/GetStudentById/{student_id}")
        public ResponseEntity<Object> GetIdMethod (@PathVariable Integer student_id)
        {
            return ResponseEntity.ok(studentService.getStudentById(student_id));
        }
        @PostMapping("/saveStudents")
        public ResponseEntity<Object> saveStudentMethod (@RequestBody Student student)
        {
            return ResponseEntity.ok(studentService.saveStudents(student));
        }



    @GetMapping("/fetchUsersDataOnly")
    public Map<String, Object> fetchUsersDataOnly() {
        return withoutClass.fetchUsersDataOnly();
    }

    @GetMapping("/fetchNames")
    public List<String> fetchNames()
    {
        return studentService.printNames();
    }

    @GetMapping("/fetchNamesUsingStatic")
    public List<String> fetchingNames()
    {
        return studentService.printNamesUsingStatic();
    }
    @GetMapping("/fetchUsersFull")
    public Map<String, Object> fetchUsersFull() {
        return withoutClass.fetchUsersFull();
    }

    @GetMapping("/fetchUnknownList")
    public Map<String, Object> fetchUnknownList() {
        return withoutClass.fetchUnknownList();
    }

    @PostMapping("/postNewUser")
    public Map<String, Object> postNewUser(@RequestBody Map<String, Object> userData) {
        return withoutClass.postNewUser(userData);
    }
}
