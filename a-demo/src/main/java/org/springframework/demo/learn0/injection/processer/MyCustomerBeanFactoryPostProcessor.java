package org.springframework.demo.learn0.injection.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyCustomerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MMMM MyCustomerBeanFactoryPostProcessor postProcessBeanFactory " + beanFactory);
		// 插手 beanfactory实例化bean过程, 修改某个注入的bean的信息
//		BeanDefinition definition = beanFactory.getBeanDefinition("demoService");
//		definition.setScope("prototype");
	}
}
