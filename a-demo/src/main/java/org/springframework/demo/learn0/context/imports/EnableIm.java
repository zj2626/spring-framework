package org.springframework.demo.learn0.context.imports;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportSelector.class)
/**
 * 模拟 springboot中的enable注解, 可以控制对应的bean是否加入容器
 */
public @interface EnableIm {
}
