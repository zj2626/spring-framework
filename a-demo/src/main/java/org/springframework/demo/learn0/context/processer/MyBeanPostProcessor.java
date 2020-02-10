package org.springframework.demo.learn0.context.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * 实现BeanPostProcessor接口,可以插入自己的操作在bean实例化前后
 * 实现PriorityOrdered接口,可以控制自定义实例化过程的不同的Processor的顺序
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {
	// bean初始化之前
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MM-BP MyBeanPostProcessor postProcessBeforeInitialization " + bean);
		return bean;
	}

	// bean初始化之后
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MM-BP MyBeanPostProcessor  postProcessAfterInitialization " + bean);
		return bean;
	}

	@Override
	public int getOrder() {
		// 越小越先执行
		return 100;
	}
}
