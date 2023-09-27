package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * &#064;Configuration指定一个类为配置类，可以添加配置注解，替代配置xml文件
 * <p>
 * &#064;ComponentScan(basePackages  = {"包","包"}) 替代<context:component-scan标签实现注解扫描
 * <p>
 * &#064;PropertySource("classpath:配置文件地址")  替代 <context:property-placeholder标签
 */
@ComponentScan("org.example.ioc_01")
@PropertySource("classpath:jdbc.properties")
@Configurable
public class JavaConfiguration {

    @Value("${example.url}")
    private String url;

    @Value("${example.driver}")
    private String driver;

    @Value("${example.username}")
    private String username;

    @Value("${example.password}")
    private String password;

    /**
     * 方法名 == bean id
     * 解决方案: 配置类方式,可以使用方法返回值+@Bean注解
     *
     * @return druidDataSource连接池
     */
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        /*
          方案一：如果对方是@Bean方法 直接调用即可dataSource()  不推荐
          方案二：形参列表声明想要的组建的类型 ioc容器也会自动注入 形参必须得有
         */
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }


}
