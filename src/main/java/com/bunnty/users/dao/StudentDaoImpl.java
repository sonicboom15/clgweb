package com.bunnty.users.dao;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bunnty.users.model.Student;
 

@Repository
public class StudentDaoImpl implements StudentDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }
 
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
 
        return sessionFactory.getCurrentSession().createQuery("from Employee")
                .list();
    }
 
    public Student getStudent(int studentid) {
        return (Student) sessionFactory.getCurrentSession().get(
                Student.class, studentid);
    }
 
    @Override
    public Student updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return student;
    }

	@Override
	public void deleteStudent(int studentid) {
		 Student student = (Student) sessionFactory.getCurrentSession().load(
	                Student.class, studentid);
	        if (null != student) {
	            this.sessionFactory.getCurrentSession().delete(student);
	        }
		
	}

}