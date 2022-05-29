package com.SpringDataJpa.StudentsRecords.Controllers;

import com.SpringDataJpa.StudentsRecords.Models.Student;
import com.SpringDataJpa.StudentsRecords.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/saveStudenDetail")
    public ResponseEntity saveStudentDetail(@RequestBody Student details){
        Student result = null;
        try{
            LOGGER.info("[ start ] : saveStudentDetail() started.");
            result = this.studentService.saveStudents(details);
            LOGGER.info("[ End ] : saveStudentDetails() ended.");

            return new ResponseEntity(result, HttpStatus.CREATED);
        }
        catch(Exception e){
            LOGGER.error("[ Error ]: error in saveStudentDetails",e);
            return new ResponseEntity(result,HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/updateStudentDetail")
    public ResponseEntity updateStudentDetail(@RequestBody Student details){
        Student result = null;
        try{
            LOGGER.info("[ start ] : updateStudentDetail() started.");
            result = this.studentService.updateStudentDetail(details);
            LOGGER.info("[ End ] : updateStudentDetail() ended.");

            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch(Exception e){
            LOGGER.error("[ Error ] : error in updateStudentDetail(). ",e);
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity deleteStudentById(@PathVariable("id") Long id){
        try{
            LOGGER.info("[ start ] : deleteStudentById() started.");
             this.studentService.deleteStudentById(id);
            LOGGER.info("[ End ] : deleteStudentById() ended.");

            return new ResponseEntity("Student record successfully deleted.", HttpStatus.OK);
        }
        catch(Exception e){
            LOGGER.error("[ Error ] : error in deleteStudentById(). ",e);
            return new ResponseEntity("Student record deletion un-successful.", HttpStatus.BAD_REQUEST);
        }
    }
}
