package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.demo.learn0.context.bean.DemoSimpleDao;
import org.springframework.demo.learn0.context.bean.DemoUPService;
import org.springframework.stereotype.Service;

@Service("DemoCPService")
public class DemoCPService {

	private DemoDao dao;

	private DemoUPService upService;

	@Autowired
	private DemoSimpleDao simpleDao;

	//	@Autowired
	//	public DemoCPService() {
	//		System.out.println("DemoCPService 0 Constructor ");
	//	}

	//	@Autowired
	public DemoCPService(DemoDao dao) {
		this.dao = dao;
		System.out.println("DemoCPService 1 Constructor ");
	}

	@Autowired // TODO ???
	public DemoCPService(DemoUPService upService) {
		this.upService = upService;
		System.out.println("DemoCPService 2 Constructor ");
	}

	//	@Autowired
	public DemoCPService(DemoDao dao, DemoSimpleDao simpleDao) {
		this.dao = dao;
		this.simpleDao = simpleDao;
		System.out.println("DemoCPService 3 Constructor ");
	}

	public void doQuery() {
		System.out.println("DemoCPService do query !");
		if (null != simpleDao) {
			System.out.println("pDao != null is true");
			simpleDao.doQuery();
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
//				", simpleDao=" + simpleDao + // TODO ??? java.lang.StackOverflowError
				'}';
	}
}
