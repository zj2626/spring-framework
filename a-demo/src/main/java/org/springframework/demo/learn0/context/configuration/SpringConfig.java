package org.springframework.demo.learn0.context.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.demo.learn0.context.bean.impl.DemoDownService;
import org.springframework.demo.learn0.context.bean.impl.DemoUpService;
import org.springframework.demo.learn0.context.imports.EnableIm;
import org.springframework.demo.learn0.context.registrar.MyMapperScan;

@Configuration
@ComponentScan(value = "org.springframework.demo.learn0.context")
@MyMapperScan(value = "org.springframework.demo.learn0.injection.bean")
@EnableIm // 开启则启用其引用的MyImportSelector, 注入 DemoImServiceImpl 和 MyAopBeanPostProcessor, 其中MyAopBeanPostProcessor会通过反射代理DemoImDaoImpl
public class SpringConfig {

	@Bean
	public DemoUpService demoUpService(){
		// 当加了@Configuration, 则这里只会调用一次, demoDownService()方法中的调用会被拦截,直接从beanFactory中获取DemoUpService
		return new DemoUpService();
	}


	@Bean
	public DemoDownService demoDownService(){
		demoUpService();
		return new DemoDownService();
	}
}
