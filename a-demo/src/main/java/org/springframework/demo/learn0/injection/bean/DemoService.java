package org.springframework.demo.learn0.injection.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DemoService {

	@Autowired
	private DemoDao dao;

	@Autowired
	private DemoPDao pDao;

	public DemoService() {
		System.out.println("\nDemoService Constructor");
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
}
