package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.demo.learn0.context.bean.DemoSimpleDao;
import org.springframework.stereotype.Repository;

@Repository
public class DemoSimpleDaoImpl implements DemoSimpleDao {
	@Autowired
	private DemoCPServiceImpl cpService;

	public DemoSimpleDaoImpl() {
		System.out.println("DemoSimpleDao Constructor " + cpService);
	}

	@Override
	public void doQuery() {
		System.out.println("DemoSimpleDao query sql " + cpService);
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoSimpleDao{" +
				"cpService=" + cpService +
				'}';
	}
}
