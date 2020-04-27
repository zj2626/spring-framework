package org.springframework.demo.learn0.context.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("执行MyBeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("执行MyBeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法");
		// 插手 beanfactory实例化bean过程, 修改某个注入的bean的信息
		//		BeanDefinition definition = beanFactory.getBeanDefinition("demoService");
		//		definition.setScope("prototype");
	}
}
