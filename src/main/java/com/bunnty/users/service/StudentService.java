package com.bunnty.users.service;

import java.util.List;

import com.bunnty.users.model.Student;
 
 
public interface StudentService {
     
    public void addStudent(Student student);
 
    public List<Student> getAllStudents();
 
    public void deleteStudent(Integer studentId);
 
    public Student getStudent(int studentid);
 
    public Student updateStudent(Student student);
}
