package org.springframework.demo.learn0.context.imports;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.demo.learn0.context.bean.impl.DemoImServiceImpl;

public class MyImportSelector implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		System.out.println("执行MyImportSelector的selectImports方法 导入需要的bean ");

		if (importingClassMetadata.isAnnotated(EnableIm.class.getName())) {
			return new String[]{DemoImServiceImpl.class.getName(), MyAopBeanPostProcessor.class.getName()};
		} else {
			return new String[0];
		}
	}
}
