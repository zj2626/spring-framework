package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoPDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DemoService {

	@Autowired
	private DemoDao dao;

	@Autowired
	private DemoPDao pDao;

	public DemoService() {
		System.out.println("DemoService Constructor " + dao + " | " + pDao);
	}

	@PostConstruct
	public void init(){
		System.out.println("DemoService PostConstruct " + dao);
	}

	public void doQuery() {
		System.out.println("do query !");
		dao.doQuery();
		pDao.doQuery("dd demo");
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("$$_" + this.getClass().getSimpleName() + "-" + super.hashCode() + ": {");
		sb.append("\"dao\":")
				.append(dao);
		sb.append(",\"pDao\":")
				.append(pDao);
		sb.append('}');
		return sb.toString();
	}
}
