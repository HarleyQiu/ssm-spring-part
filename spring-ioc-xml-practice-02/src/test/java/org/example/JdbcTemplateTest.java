package org.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.example.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {

    /**
     * JdbcTemplate 是 Spring 框架提供的一个 JDBC 操作辅助类
     * 通过 JdbcTemplate 可以简化 JDBC 操作，例如不用再手动创建 Connection、Statement、ResultSet 等对象
     * <p>
     * DruidDataSource 是阿里巴巴提供的一个数据库连接池 负责管理数据库连接
     */
    public void testForJava() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql:///studb?useUnicode=true&characterEncoding=utf8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        jdbcTemplate.setDataSource(druidDataSource);
        // jdbcTemplate.update();  // DDL DML DCL 非查询语句
        // jdbcTemplate.queryForObject()  // 查询语句 返回单个对象
        // jdbcTemplate.query()  // DQL 查询语句 返回多个对象
    }

    @Test
    public void testForIoc() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
        String sql = "insert into students(id, name, gender, age, class) values(?, ?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, "1001", "张三", "男", 18, "一班");
        System.out.println("rows = " + rows);

        sql = "select * from students where id = ?";
        /*
          1. sql 查询语句
          2. RowMapper 行映射器
          3. 可变参数
         */
        Student query = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                    // rs 结果集
                    // rowNum 行号
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setGender(rs.getString("gender"));
                    student.setAge(rs.getInt("age"));
                    student.setClasses(rs.getString("class"));
                    return student;
                }, 1
        );

        System.out.println("query = " + query);

        sql = "select id, name, gender, age, class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        studentList.forEach(System.out::println);

        // 删除id为1001的记录
        sql = "delete from students where id = ?";
        rows = jdbcTemplate.update(sql, 1001);
        System.out.println("rows = " + rows);

        context.close();
    }
}
