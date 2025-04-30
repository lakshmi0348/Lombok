package com.example.Lombok.service;

import com.example.Lombok.model.Student;
import com.example.Lombok.repository.StudentRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Autowired
    private EntityManager em;

    public List<String> printNames(){



        jakarta.persistence.Query query = em.createQuery("Select s.student_name from Student s");

        @SuppressWarnings("unchecked")
        List<String> list = query.getResultList();

        return list;


    }
    public List<String> printNamesUsingStatic(){



        Query query = em.createNamedQuery("findName");

        @SuppressWarnings("unchecked")
        List<String> list = query.getResultList();

        return list;

    }


}
