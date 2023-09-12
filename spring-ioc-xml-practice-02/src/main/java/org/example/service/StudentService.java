package org.example.service;

import org.example.pojo.Student;

import java.util.List;

public interface StudentService {

    /**
     * 查询全部学生
     *
     * @return 学生列表
     */
    List<Student> findAll();
}
