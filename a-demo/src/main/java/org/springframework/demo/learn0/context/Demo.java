package org.springframework.demo.learn0.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.demo.learn0.context.bean.*;
import org.springframework.demo.learn0.context.bean.impl.DemoDownService;
import org.springframework.demo.learn0.context.bean.impl.DemoService;
import org.springframework.demo.learn0.context.bean.DemoUPService;
import org.springframework.demo.learn0.context.configuration.SpringConfig;
import org.springframework.demo.learn0.context.processer.MyCustomerBeanFactoryPostProcessor;

public class Demo {
	/**
	 * * @Junit见test目录
	 *
	 * @param args
	 */
	public static void main(String[] args) {
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

			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> FINISH <<<<<<<<<<<<<<<<<<<<<");

			DemoService service = context.getBean(DemoService.class);
			System.out.println(service + "\n");
			System.out.println(context.getBean(DemoService.class) + "\n");
			System.out.println(context.getBean(DemoDao.class) + "\n");

			DemoUPService upService = (DemoUPService) context.getBean("demoUpService");
			System.out.println(upService);
			upService.doQuery();

			((DemoPDao) context.getBean("demoPDao")).doQuery("ss");
			System.out.println();
			System.out.println();

			DemoImDao imDao = (DemoImDao) context.getBean("demoImDaoImpl");
			System.out.println(imDao);
			imDao.doQuery();
			System.out.println();

			DemoImService imService = context.getBean(DemoImService.class);
			System.out.println(imService);
			imService.doQuery();
			System.out.println();

			System.out.println(context.getBean(DemoDownService.class) + "\n");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
