package org.springframework.demo.learn0.injection.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportBeanDefinitionRegistrar.class)
/**
 * 模拟 Mybatis
 */
public @interface MyMapperScan {
	String[] value();
}
