package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoImDao;
import org.springframework.demo.learn0.context.bean.DemoPDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("DemoCPService")
public class DemoCPService {

	private DemoDao dao;

	@Autowired
	private DemoImDao imDao;

	private DemoPDao pDao;

	public DemoCPService() {
		System.out.println("DemoConstructService 0 Constructor " + dao + " | " + imDao + " | " + pDao);
	}

	public DemoCPService(DemoDao dao) {
		this.dao = dao;
		System.out.println("DemoConstructService 1 Constructor " + dao + " | " + imDao + " | " + pDao);
	}

	@Autowired
	public DemoCPService(DemoPDao pDao) {
		this.pDao = pDao;
		System.out.println("DemoConstructService 2 Constructor " + dao + " | " + imDao + " | " + pDao);
	}

	public void doQuery() {
		System.out.println("do query !");
		pDao.doQuery("AAA");
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoCPService{" +
				"dao=" + dao +
				", imDao=" + imDao +
				", pDao=" + pDao +
				'}';
	}
}
