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
		final StringBuilder sb = new StringBuilder("$$_" + this.getClass().getSimpleName() + "-" + super.hashCode() + ": {");
		sb.append("\"dao\":")
				.append(dao);
		sb.append('}');
		return sb.toString();
	}
}
