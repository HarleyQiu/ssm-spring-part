package org.example.service.impl;

import org.example.dao.StudentDao;
import org.example.pojo.Student;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询全部学生
     *
     * @return 学生列表
     */
    @Override
    public List<Student> findAll() {
        List<Student> students = studentDao.queryAll();
        System.out.println("StudentService = " + students);
        return students;
    }
}
