package org.springframework.demo.learn0.context.registrar;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class MyFactoryBean implements FactoryBean<Object>, InvocationHandler {
	private Class<?> clazz;

	public MyFactoryBean(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object getObject() throws Exception {
		System.out.println("~ ~ ~ ~ Proxy getObject ~ ~ ~ ~ "  + clazz);
		Class<?>[] interfaces = new Class<?>[]{clazz};
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, this);
	}

	@Override
	public Class<?> getObjectType() {
		return clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("~ ~ ~ ~ Proxy invoke ~ ~ ~ ~ " + clazz + " | " + method.getName() + " | " + Arrays.toString(args));

		// 直接获取方法上的注解中的sql语句->执行(模拟)
		if (method.isAnnotationPresent(MySelect.class)) {
			MySelect mySelect = method.getDeclaredAnnotation(MySelect.class);
			System.out.println("执行sql" + Arrays.toString(mySelect.sql()));
		}
		return null;
	}
}
