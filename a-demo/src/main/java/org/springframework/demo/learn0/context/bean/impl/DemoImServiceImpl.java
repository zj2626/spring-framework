package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoImService;

public class DemoImServiceImpl implements DemoImService {

	@Autowired
	private DemoDao dao;

	public DemoImServiceImpl() {
		System.out.println("\nDemoImService Constructor");
	}

	@Override
	public void doQuery() {
		dao.doQuery();
	}
}
