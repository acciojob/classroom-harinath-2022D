package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private Map<String, Student> studentMap = new HashMap<>();
    private Map<String, Teacher> teacherMap = new HashMap<>();
    private Map<String, List<String>> teacher_student = new HashMap<>();
    public void addStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addStudent_Teacher(String student, String teacher) {
        if(!teacher_student.containsKey(teacher)){
            teacher_student.put(teacher, new ArrayList<>());
        }
        List<String> studentlist = teacher_student.get(teacher);
        studentlist.add(student);
        teacher_student.put(teacher,studentlist);
    }

    public Student getStudent(String name) {
        return studentMap.get(name);
    }

    public Teacher getTeacher(String name) {
        return teacherMap.get(name);
    }

    public List<String> getStudentByTeacher(String teacher) {
        return teacher_student.get(teacher);
    }

    public List<String> getAllStudent() {
        return new ArrayList<String>(studentMap.keySet());
    }

    public void deleteTeacher_Student(String teacher) {
        if(teacher_student.containsKey(teacher)){
            for(String stu : teacher_student.get(teacher)) {
                studentMap.remove(stu);
            }
        }
        teacher_student.remove(teacher);
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }

    public void deleteAllTeachersAndStudents() {
//        for(String teach : teacherMap.keySet()){
//            deleteTeacher_Student(teach);
//        }
        teacherMap.clear();
        //teacherMap = new HashMap<>();
        studentMap = new HashMap<>();
        teacher_student = new HashMap<>();
    }

}
