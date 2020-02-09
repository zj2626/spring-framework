package org.springframework.demo.learn0.injection.bean;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class DemoDaoImpl implements DemoDao {
    private Integer id;


	public DemoDaoImpl() {
		System.out.println("\nDemoDao Constructor");
	}

	@PostConstruct
	public void init(){
		System.out.println("DemoDao PostConstruct");
	}

    @Override
    public void doQuery() {
        System.out.println("query sql " + id);
    }
}
