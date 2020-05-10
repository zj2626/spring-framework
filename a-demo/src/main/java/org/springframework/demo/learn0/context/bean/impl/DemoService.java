package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoPDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DemoService implements InitializingBean {

	private Integer id;

	@Autowired
	private DemoDao dao;

	@Autowired
	private DemoPDao pDao;

	public DemoService() {
		System.out.println("DemoService Constructor " + dao + " | " + pDao);
	}

	@PostConstruct
	public void postConstructMethod(){
		id = 4;
		System.out.println("DemoService PostConstruct " + dao);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		id = 3;
		System.out.println("DemoService afterPropertiesSet " + dao);
	}

	public void doQuery() {
		System.out.println("DemoService do query !");
		dao.doQuery();
		pDao.doQuery("dd demo");
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoService{" +
				"dao=" + dao +
				", pDao=" + pDao +
				'}';
	}

}
