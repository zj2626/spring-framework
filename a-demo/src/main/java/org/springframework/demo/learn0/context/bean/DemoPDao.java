package org.springframework.demo.learn0.context.bean;

import org.springframework.demo.learn0.context.registrar.MySelect;

public interface DemoPDao {

	@MySelect(sql = "select * form test where id = %{msg}%")
    void doQuery(String msg);
}
