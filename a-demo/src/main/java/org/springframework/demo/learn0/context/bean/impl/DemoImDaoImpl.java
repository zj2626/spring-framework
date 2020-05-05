package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.demo.learn0.context.bean.DemoImDao;
import org.springframework.stereotype.Repository;

@Repository
public class DemoImDaoImpl implements DemoImDao {
	private Integer id = 1;

	public DemoImDaoImpl() {
		System.out.println("DemoImDao Constructor " + id);
	}

	@Override
	public void doQuery() {
		System.out.println("query sql " + id);
	}

	@Override
	public String toString() {
		return "[TO_STRING] DemoImDaoImpl{" +
				"id=" + id +
				'}';
	}
}
