package com.ojaoba.mongoDb.service;


import com.ojaoba.mongoDb.model.Student;
import com.ojaoba.mongoDb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> geAllStudents() {
       return studentRepository.findAll();

    }

    public void createStudent(Student student) {

        studentRepository.findStudentByEmail(student.getEmail())
                .ifPresentOrElse(s->
                {
                    System.out.println(s + " already exists ");

                }, () -> {
                    System.out.println("Inserting student " + student);

                    studentRepository.insert(student);

                });

    }

    public void updateCustomer(Student student) {
        studentRepository.save(student);
    }

    public void deleteCustomer(String id) {
        studentRepository.deleteById(id);
    }
}
