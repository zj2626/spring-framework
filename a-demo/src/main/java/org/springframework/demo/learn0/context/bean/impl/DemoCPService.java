package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoPDao;
import org.springframework.demo.learn0.context.bean.DemoUPService;
import org.springframework.stereotype.Service;

@Service("DemoCPService")
public class DemoCPService {

	private DemoDao dao;

	private DemoUPService upService;

	@Autowired
	private DemoPDao pDao;

	//	@Autowired
	//	public DemoCPService() {
	//		System.out.println("DemoCPService 0 Constructor " + dao + " | " + upService + " | " + pDao);
	//	}

	//	@Autowired
	public DemoCPService(DemoDao dao) {
		this.dao = dao;
		System.out.println("DemoCPService 1 Constructor " + dao + " | " + upService + " | " + pDao);
	}

	@Autowired // TODO ???
	public DemoCPService(DemoUPService upService) {
		this.upService = upService;
		System.out.println("DemoCPService 1 Constructor " + dao + " | " + upService + " | " + pDao);
	}

//	@Autowired
	public DemoCPService(DemoDao dao, DemoPDao pDao) {
		this.dao = dao;
		this.pDao = pDao;
		System.out.println("DemoCPService 2 Constructor " + dao + " | " + upService + " | " + pDao);
	}

	public void doQuery() {
		System.out.println("DemoCPService do query !");
		if (null != pDao) {
			System.out.println("pDao != null is true");
			pDao.doQuery("AAA");
		}
		if (null != dao) {
			dao.doQuery();
		}
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoCPService{" +
				"dao=" + dao +
				", upService=" + upService +
				", pDao=" + pDao +
				'}';
	}
}
