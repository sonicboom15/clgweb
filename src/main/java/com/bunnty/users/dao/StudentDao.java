package com.bunnty.users.dao;
 
import java.util.List;

import com.bunnty.users.model.Student;
 
public interface StudentDao {
 
    public void addStudent(Student student);
 
    public List<Student> getAllStudents();
 
    public void deleteStudent(int studentid);
 
    public Student updateStudent(Student student);
 
    public Student getStudent(int studentid);
}
