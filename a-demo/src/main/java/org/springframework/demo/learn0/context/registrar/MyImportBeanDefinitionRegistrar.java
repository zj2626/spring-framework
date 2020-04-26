package org.springframework.demo.learn0.context.registrar;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.demo.learn0.context.bean.DemoPDao;
import org.springframework.stereotype.Component;

@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * 步骤
	 * 1. 扫描包路径下的所有的Mapper(模拟), 也就是方法上有注解 @MySelect 的类
	 * 2. 构建 BeanDefinition 用来注册到Spring容器中
	 * 3. 由于Mappe只有接口 所以需要通过反射动态生成接口的实现, 而由于是动态生成,所以需要通过 FactoryBean 的形式获得 BeanClass
	 * 4. 最终构建的 BeanDefinition 注册到容器中
	 *
	 * @param importingClassMetadata annotation metadata of the importing class
	 * @param registry               current bean definition registry
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("执行MyImportBeanDefinitionRegistrar的registerBeanDefinitions方法, 导入MyFactoryBean(demoPDao)");

		// 扫描结果
		Class<?>[] clazzes = new Class<?>[]{DemoPDao.class};

		for (Class<?> clazz : clazzes) {
			// 构建 - 注册
			BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
			AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
			// spring 会通过全限定名获得对应的Class对象, 从而调用对应的构造方法
			String beanClassName = beanDefinition.getBeanClassName();
			// 通过自定义的 FactoryBean 可以返回指定的接口的代理对象(此时如果调用getBeanClassName()得到的就是FactoryBean了)
			beanDefinition.setBeanClass(MyFactoryBean.class);
			// 由于自定义的FactoryBean没有默认构造方法, 所以需要传递构造方法的参数, 即一个Class对象, 这样就可以在这里把要代理的接口提供给FactoryBean, 也就是说可以重复利用FactoryBean
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
			registry.registerBeanDefinition("demoPDao", beanDefinition);
		}
	}
}
