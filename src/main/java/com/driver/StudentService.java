package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void addStudent_Teacher(String student, String teachet) {
        studentRepository.addStudent_Teacher(student,teachet);
    }

    public Student getStudent(String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher(String name) {
        return studentRepository.getTeacher(name);
    }

    public List<String> getStudentByTeacher(String teacher) {
        List<String> studentlist = studentRepository.getStudentByTeacher(teacher);
        return studentlist;
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    public void deleteTeacher_Student(String teacher) {

        studentRepository.deleteTeacher_Student(teacher);
    }

    public void deleteAllTeachersAndStudents() {
        studentRepository.deleteAllTeachersAndStudents();
    }
}
