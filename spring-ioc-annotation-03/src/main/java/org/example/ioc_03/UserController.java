package org.example.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    @Autowired  // boolean required() default true;默认必须有对应类型的组件  不推荐设置为false 不然后期调用会出现空指针
    private UserService userService;

    @Resource(name = "userServiceImpl")
    private UserService newUserService;


    public void show() {
        System.out.println("userService.show() = " + userService.show());
        System.out.println("newUserService.show() = " + newUserService.show());
    }
}
