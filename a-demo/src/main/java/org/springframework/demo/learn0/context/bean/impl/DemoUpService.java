package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;

public class DemoUpService {

	@Autowired
	private DemoDao dao;

	public DemoUpService() {
		System.out.println("\nDemoUpService Constructor");
	}


	public void doQuery() {
		dao.doQuery();
	}
}
