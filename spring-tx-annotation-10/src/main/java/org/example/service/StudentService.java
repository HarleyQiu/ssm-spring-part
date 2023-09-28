package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 1. 如果只有查操作 可以将查操作的方法 设置为只读模式 @Transactional(readOnly = true)
 * 2. 设置@Transactional(timeout = 秒数)超时时间 就会回滚事务和释放异常   默认: -1 永不超时,不限制事务时间!
 * 3. rollbackFor = 指定哪些异常才会回滚,默认是 RuntimeException and Error 异常方可回滚
 * 4. noRollbackFor = 指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内
 * 5. isolation = 设置事务的隔离级别,mysql默认是repeatable read!
 */
@Service
@Transactional(timeout = 3, rollbackFor = Exception.class, noRollbackFor = FileNotFoundException.class)
public class StudentService {

    @Autowired
    private StudentDao studentDao;


    public void changeInfo() throws FileNotFoundException {
        studentDao.updateAgeById(88, 1);
        new FileInputStream("xxx");
        System.out.println("-----------");
        studentDao.updateNameById("test2", 1);
    }

    // readOnly = true把当前事务设置为只读
    @Transactional(readOnly = true)
    public String getEmpName(Integer empId) {
        return "";
    }


}
