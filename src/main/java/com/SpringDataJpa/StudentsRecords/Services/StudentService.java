package com.SpringDataJpa.StudentsRecords.Services;

import com.SpringDataJpa.StudentsRecords.Models.Student;
import com.SpringDataJpa.StudentsRecords.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student>  fetchAllStudents(){
        return this.studentRepo.findAll();
    }
}
