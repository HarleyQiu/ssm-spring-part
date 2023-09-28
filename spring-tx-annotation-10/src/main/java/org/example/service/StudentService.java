package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 1. 如果只有查操作 可以将查操作的方法 设置为只读模式 @Transactional(readOnly = true)
 * 2. 设置@Transactional(timeout = 秒数)超时时间 就会回滚事务和释放异常   默认: -1 永不超时,不限制事务时间!
 * 3. rollbackFor = 指定哪些异常才会回滚,默认是 RuntimeException and Error 异常方可回滚
 * 4. noRollbackFor = 指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内
 * 5. isolation = 设置事务的隔离级别,mysql默认是repeatable read!
 * 6. 其他传播行为值（了解）
 *  6-1. Propagation.REQUIRED：如果当前存在事务，则加入当前事务，否则创建一个新事务。   默认值
 *  6-2. Propagation.REQUIRES_NEW：创建一个新事务，并在新事务中执行。如果当前存在事务，则挂起当前事务，即使新事务抛出异常，也不会影响当前事务。
 *  6-3. Propagation.NESTED：如果当前存在事务，则在该事务中嵌套一个新事务，如果没有事务，则与Propagation.REQUIRED一样。
 *  6-4. Propagation.SUPPORTS：如果当前存在事务，则加入该事务，否则以非事务方式执行。
 *  6-5. Propagation.NOT_SUPPORTED：以非事务方式执行，如果当前存在事务，挂起该事务。
 *  6-6. Propagation.MANDATORY：必须在一个已有的事务中执行，否则抛出异常。
 *  6-7. Propagation.NEVER：必须在没有事务的情况下执行，否则抛出异常。
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

    /**
     * 声明两个独立修改数据库的事务业务方法
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge() {
        studentDao.updateAgeById(100, 1);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName() {
        studentDao.updateNameById("test3", 1);
        int i = 1 / 0;
    }


}
