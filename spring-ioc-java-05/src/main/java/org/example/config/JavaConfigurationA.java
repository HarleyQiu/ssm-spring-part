package org.example.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Import;

@Import(JavaConfigurationB.class)
@Configurable
public class JavaConfigurationA {


}
