package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoPDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("DemoCPService")
public class DemoCPService {

	private DemoDao dao;

	private DemoPDao pDao;

	public DemoCPService() {
		System.out.println("DemoConstructService 0 Constructor " + dao + " | " + pDao);
	}

	public DemoCPService(DemoDao dao) {
		System.out.println("DemoConstructService 1 Constructor " + dao + " | " + pDao);
		this.dao = dao;
	}

	@Autowired
	public DemoCPService(DemoDao dao, DemoPDao pDao) {
		System.out.println("DemoConstructService 2 Constructor " + dao + " | " + pDao);
		this.dao = dao;
		this.pDao = pDao;
	}

	public void doQuery() {
		System.out.println("do query !");
		dao.doQuery();
		pDao.doQuery("AAA");
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoCPService{" +
				"dao=" + dao +
				", pDao=" + pDao +
				'}';
	}
}
