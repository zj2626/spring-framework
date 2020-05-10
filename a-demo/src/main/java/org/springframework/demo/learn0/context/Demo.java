package org.springframework.demo.learn0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.demo.learn0.context.bean.*;
import org.springframework.demo.learn0.context.bean.impl.DemoCPService;
import org.springframework.demo.learn0.context.bean.impl.DemoDownService;
import org.springframework.demo.learn0.context.bean.impl.DemoService;
import org.springframework.demo.learn0.context.bean.DemoUPService;
import org.springframework.demo.learn0.context.configuration.SpringConfig;
import org.springframework.demo.learn0.context.processer.MyCustomerBeanFactoryPostProcessor;

public class Demo {

	private static AnnotationConfigApplicationContext getContext() {
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

			System.out.println("\n>>>>>>>>>>>>>>>>>>>>> FINISH <<<<<<<<<<<<<<<<<<<<<\n\n");

			return context;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void print1(ApplicationContext context){
		DemoService service = context.getBean(DemoService.class);
		System.out.println(service + "\n");
		System.out.println(context.getBean(DemoService.class) + "\n");
		System.out.println(context.getBean(DemoDao.class) + "\n");
	}

	public static void print2(ApplicationContext context){
		DemoUPService upService = (DemoUPService) context.getBean("demoUpService");
		System.out.println(upService);
		upService.doQuery();
	}

	public static void print3(ApplicationContext context){
		((DemoPDao) context.getBean("demoPDao")).doQuery("ss");
	}

	public static void print4(ApplicationContext context){
		DemoImDao imDao = (DemoImDao) context.getBean("demoImDaoImpl");
		System.out.println(imDao);
		imDao.doQuery();
	}

	public static void print5(ApplicationContext context){
		DemoImService imService = context.getBean(DemoImService.class);
		System.out.println(imService);
		imService.doQuery();
	}

	public static void print6(ApplicationContext context){
		System.out.println(context.getBean(DemoDownService.class) + "\n");
	}

	public static void print7(ApplicationContext context){
		DemoCPService demoCPService = context.getBean(DemoCPService.class);
		System.out.println(demoCPService);
		System.out.println("\n___________________________________________\n");
		demoCPService.doQuery();
		System.out.println("\n___________________________________________\n");
		System.out.println(demoCPService);
	}

	/**
	 * * @Junit见test目录
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = getContext();
		print7(context);
	}
}
