package com.chl.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-12-18 10:49
 **/
public class TestCourse {
    public static void main(String[] args) throws FileNotFoundException {
        Teacher teacher = new Teacher("T10001", "王老师");
        Student[] students = new Student[]{
                new Student("S1001", "张一"),
                new Student("S1002", "张二"),
                new Student("S1003", "张三")
        };
        List<Student> studentList = Arrays.asList(students);
        Map<String, Object> map = new HashMap<>(8);
        map.put("courseName", "Java程序设计");
        map.put("teacher", teacher);
        map.put("studentList", studentList);

        PrintStream ps = new PrintStream(new FileOutputStream("/Users/mqxu/Desktop/result.txt"));

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if ("courseName" .equals(entry.getKey())) {
                System.out.println("课程名称：" + entry.getValue());
                ps.println("课程名称：" + entry.getValue());
            }
            if ("teacher" .equals(entry.getKey())) {
                Teacher t = (Teacher) entry.getValue();
                System.out.println("任课老师：" + t.getTName());
                ps.print("任课老师：" + t.getTName());
            }
            if ("studentList" .equals(entry.getKey())) {
                System.out.println("选课学生：");
                List<Student> list = (List<Student>) entry.getValue();
                for (Student student : list) {
                    System.out.println(student.getSId() + "," + student.getSName());
                    ps.println(student.getSId() + "," + student.getSName());
                }
            }
        }
    }
}
