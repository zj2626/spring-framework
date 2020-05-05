package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoUPService;

public class DemoUPServiceImpl implements DemoUPService {

	@Autowired
	private DemoDao dao;

	public DemoUPServiceImpl() {
		System.out.println("DemoUpService Constructor " + dao);
	}

	@Override
	public void doQuery() {
		dao.doQuery();
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoUPServiceImpl{" +
				"dao=" + dao +
				'}';
	}
}
