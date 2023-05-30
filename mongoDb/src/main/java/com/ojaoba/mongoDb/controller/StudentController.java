package com.ojaoba.mongoDb.controller;

import com.ojaoba.mongoDb.model.Student;
import com.ojaoba.mongoDb.model.StudentRequest;
import com.ojaoba.mongoDb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping

    public List<Student> fetchAllStudents(){

        return  studentService.geAllStudents();


    }


    @PostMapping
    public void createStudent(@RequestBody StudentRequest studentRequest){
        Student student =new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setAddress(studentRequest.getAddress());
        student.setTotalSpentInBooks(studentRequest.getTotalSpentInBooks());
        student.setCreated(LocalDateTime.now());
        student.setFavouriteSubjects(studentRequest.getFavouriteSubjects());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());

        studentService.createStudent(student);

    }

    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") String id, @RequestBody StudentRequest studentRequest){
        Student student =new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setAddress(studentRequest.getAddress());
        student.setTotalSpentInBooks(studentRequest.getTotalSpentInBooks());
        student.setCreated(LocalDateTime.now());
        student.setFavouriteSubjects(studentRequest.getFavouriteSubjects());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());
        student.setId(id);

        studentService.updateCustomer(student);

    }


    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") String id){


        studentService.deleteCustomer(id);

    }

}





