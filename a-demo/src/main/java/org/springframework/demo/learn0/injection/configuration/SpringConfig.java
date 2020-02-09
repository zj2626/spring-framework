package org.springframework.demo.learn0.injection.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.demo.learn0.injection.registrar.MyMapperScan;

@Configuration
@ComponentScan(value = "org.springframework.demo.learn0.injection")
@MyMapperScan(value = "org.springframework.demo.learn0.injection.bean")
public class SpringConfig {
}
