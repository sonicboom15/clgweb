package com.bunnty.users.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bunnty.users.dao.StudentDao;
import com.bunnty.users.model.Student;
  
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
 
    @Autowired
    private StudentDao studentDao;
 
    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
 
    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }
 
    @Override
    @Transactional
    public void deleteStudent(Integer studentid) {
        studentDao.deleteStudent(studentid);
    }
    public Student getStudent(int empid) {
        return studentDao.getStudent(empid);
    }
 
    public Student updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
 
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
 
}