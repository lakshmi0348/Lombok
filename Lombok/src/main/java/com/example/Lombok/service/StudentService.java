package com.example.Lombok.service;

import com.example.Lombok.model.Student;
import com.example.Lombok.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
//    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> getAllStudents()
    {
        log.info("Retrieving All Students");
        return studentRepo.findAll();
    }
    public Optional<Student> getStudentById(Integer student_id)
    {
        if(!studentRepo.existsById(student_id))
            log.error("ID is not exist on database");
        return studentRepo.findById(student_id);

    }
    public Student updateStudentById(Integer student_id,Student student)
    {
        if(!studentRepo.existsById(student_id))
            log.error("ID is not exist on the database to Update");
        log.info("Updating the Record...");
        student.setStudent_name(student.getStudent_name());
        student.setStudent_address(student.getStudent_address());
        return student;
    }
    public Student saveStudents(Student student) {
        return studentRepo.save(student);
    }
    public void deleteStudentById(Integer student_id)
    {
        if(!studentRepo.existsById(student_id))
            log.error("ID is not exist on database to delete");
        log.info("Deleting the Record...");
        studentRepo.deleteById(student_id);
    }


}
