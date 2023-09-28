package org.example.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@ComponentScan("org.example")
@EnableAspectJAutoProxy  // 开启aspectj
public class JavaConfig {

}
