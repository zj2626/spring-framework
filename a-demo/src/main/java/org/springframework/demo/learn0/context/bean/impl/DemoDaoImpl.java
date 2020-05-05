package org.springframework.demo.learn0.context.bean.impl;

import org.springframework.demo.learn0.context.bean.DemoDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DemoDaoImpl implements DemoDao {
    private Integer id;


	public DemoDaoImpl() {
		System.out.println("DemoDao Constructor " + id);
	}

	@PostConstruct
	public void init(){
		System.out.println("DemoDao PostConstruct");
	}

    @Override
    public void doQuery() {
        System.out.println("query sql " + id);
    }

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("$$_" + this.getClass().getSimpleName() + "-" + super.hashCode() + ": {");
		sb.append("\"id\":")
				.append(id);
		sb.append('}');
		return sb.toString();
	}
}
