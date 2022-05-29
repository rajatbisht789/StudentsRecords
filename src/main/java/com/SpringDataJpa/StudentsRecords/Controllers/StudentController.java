package com.SpringDataJpa.StudentsRecords.Controllers;

import com.SpringDataJpa.StudentsRecords.Models.Student;
import com.SpringDataJpa.StudentsRecords.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/getAllStudents")
    public ResponseEntity getAllStudents(){
        List<Student> result = null;
        try{
            LOGGER.info("[ start ] : getAllStudents() started.");
            result = this.studentService.fetchAllStudents();
            LOGGER.info("[ End ] : getAllStudent() ended.");

            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch(Exception e){
            LOGGER.error("[ Error ]: error in getAllStudents. ",e);
            return new ResponseEntity(result,HttpStatus.BAD_REQUEST);
        }
    }
}
