package org.springframework.demo.learn0.context.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EnableAspectJAutoProxy(proxyTargetClass = true)
@Aspect
@Component
public class AopConfig {

	/**
	 * DemoCPService类没有接口只有实现类, 所以采用cglib代理
	 * DemoUPService类是接口, 所以采用jdk动态代理
	 *
	 * @param joinPoint
	 */
	@Before("execution(public * org.springframework.demo.learn0.context.bean.impl.*PService*.doQuery())")
	public void beforeExec(JoinPoint joinPoint) {
		System.out.println("@Before: beforeExec " + Arrays.toString(joinPoint.getArgs()));
	}
}
