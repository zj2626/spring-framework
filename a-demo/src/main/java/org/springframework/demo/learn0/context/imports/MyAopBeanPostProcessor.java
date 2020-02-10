package org.springframework.demo.learn0.context.imports;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.demo.learn0.context.bean.DemoImDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyAopBeanPostProcessor implements BeanPostProcessor, InvocationHandler {
	private Object target;

	// bean初始化之前
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MM-BP MyAopBeanPostProcessor postProcessBeforeInitialization ");

		if (beanName.equals("demoImDaoImpl")) {
			this.target = bean;
			Class<?>[] interfaces = new Class<?>[]{DemoImDao.class};
			return Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, this);
		}

		return bean;
	}

	// bean初始化之后
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("~ ~ ~ ~ Proxy invoke2 ~ ~ ~ ~ " + target + " | " + method.getName() + " | " + Arrays.toString(args));
		return method.invoke(target, args);
	}
}
