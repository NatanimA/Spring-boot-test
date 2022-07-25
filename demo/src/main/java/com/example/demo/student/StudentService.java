package com.example.demo.student;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
      return studentRepository.findAll();
    }

    public void addStudents(Student student) {
        Optional <Student> studentOptional = studentRepository.findByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email Already Exists");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student Does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
