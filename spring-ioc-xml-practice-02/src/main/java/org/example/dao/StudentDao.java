package org.example.dao;

import org.example.pojo.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询全部学生
     *
     * @return 学生列表
     */
    List<Student> queryAll();
}
