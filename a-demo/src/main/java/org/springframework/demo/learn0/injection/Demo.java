package org.springframework.demo.learn0.injection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.demo.learn0.injection.bean.DemoDao;
import org.springframework.demo.learn0.injection.bean.DemoPDao;
import org.springframework.demo.learn0.injection.bean.DemoService;
import org.springframework.demo.learn0.injection.configuration.SpringConfig;
import org.springframework.demo.learn0.injection.processer.MyCustomerBeanFactoryPostProcessor;

public class Demo {
	/**
	 * * @Junit见test目录
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Class<?>[] clazz = new Class<?>[]{DemoPDao.class};
		try {
			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> BEGIN <<<<<<<<<<<<<<<<<<<<");
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			//		System.out.println("_________________________" + context.getBean(ConfigurationClassPostProcessor.class));

			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> BEFORE <<<<<<<<<<<<<<<<<<<<");
			context.register(SpringConfig.class);
			//		System.out.println("_________________________" + context.getBean(SpringConfig.class));

			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> AFTER <<<<<<<<<<<<<<<<<<<<");
			// 手动添加BeanFactoryPostProcessor, 也可以通过注解扫码
			context.addBeanFactoryPostProcessor(new MyCustomerBeanFactoryPostProcessor());
			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> REFRESH <<<<<<<<<<<<<<<<<<<<");
			context.refresh();

			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> FINISH <<<<<<<<<<<<<<<<<<<<");

			System.out.println(context.getBean(DemoService.class) + "\n");
			System.out.println(context.getBean(DemoService.class) + "\n");
			System.out.println(context.getBean(DemoDao.class) + "\n");
			((DemoPDao) context.getBean("demoPDao")).doQuery("ss");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
