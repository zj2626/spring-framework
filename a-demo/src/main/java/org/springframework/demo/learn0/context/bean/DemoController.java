package org.springframework.demo.learn0.context.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoCPService demoCPService;

	@Autowired
	private DemoUPService demoUPService;

	@RequestMapping("/info")
	public void info(){
		System.out.println("\n\nDemoController info\n\n");

		demoCPService.doQuery();
		demoUPService.doQuery();
	}
}
