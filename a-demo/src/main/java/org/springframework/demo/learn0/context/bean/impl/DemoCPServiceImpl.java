package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("DemoCPService")
public class DemoCPServiceImpl implements DemoCPService {

	private DemoDao dao;

	private DemoUPService upService;

	@Resource
	private DemoImDao imDao;

	@Autowired
	private DemoSimpleDao simpleDao;

	//	@Autowired
	//	public DemoCPService() {
	//		System.out.println("DemoCPService 0 Constructor ");
	//	}

	//	@Autowired
	public DemoCPServiceImpl(DemoDao dao) {
		this.dao = dao;
		System.out.println("DemoCPService 1 Constructor ");
	}

	@Autowired // TODO ???
	public DemoCPServiceImpl(DemoUPService upService) {
		this.upService = upService;
		System.out.println("DemoCPService 2 Constructor ");
	}

	//	@Autowired
	public DemoCPServiceImpl(DemoDao dao, DemoSimpleDao simpleDao) {
		this.dao = dao;
		this.simpleDao = simpleDao;
		System.out.println("DemoCPService 3 Constructor ");
	}

	@Override
	public void doQuery() {
		System.out.println("DemoCPService do query !");

		if (null != simpleDao) {
			simpleDao.doQuery();
		}
		if (null != upService) {
			upService.doQuery();
		}
		if (null != dao) {
			dao.doQuery();
		}
		if (null != imDao) {
			imDao.doQuery();
		}
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoCPService{" +
				"dao=" + dao +
				"imDao=" + imDao +
				", upService=" + upService +
				//				", simpleDao=" + simpleDao + // TODO ??? java.lang.StackOverflowError
				'}';
	}
}
