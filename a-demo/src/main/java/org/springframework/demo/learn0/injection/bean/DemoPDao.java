package org.springframework.demo.learn0.injection.bean;

import org.springframework.demo.learn0.injection.registrar.MySelect;

public interface DemoPDao {

	@MySelect(sql = "select * form test where id = %{msg}%")
    void doQuery(String msg);
}
