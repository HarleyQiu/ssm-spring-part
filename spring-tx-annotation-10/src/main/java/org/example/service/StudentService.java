package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1. 如果只有查操作 可以将查操作的方法 设置为只读模式 @Transactional(readOnly = true)
 * 2. 设置@Transactional(timeout = 秒数)超时时间 就会回滚事务和释放异常
 */
@Service
@Transactional(timeout = 3)
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    public void changeInfo() {
        studentDao.updateAgeById(88, 1);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------");
        studentDao.updateNameById("test2", 1);
    }

    // readOnly = true把当前事务设置为只读
    @Transactional(readOnly = true)
    public String getEmpName(Integer empId) {
        return "";
    }
}
