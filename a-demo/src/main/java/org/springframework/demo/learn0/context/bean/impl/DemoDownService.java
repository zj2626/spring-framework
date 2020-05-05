package org.springframework.demo.learn0.context.bean.impl;

public class DemoDownService {

	public DemoDownService() {
		System.out.println("DemoDownService Constructor");
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "-" + super.hashCode();
	}
}
