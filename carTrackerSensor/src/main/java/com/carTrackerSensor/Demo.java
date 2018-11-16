package com.carTrackerSensor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {

	@RequestMapping("demo")
	public List<DemoClass> getInt(){
		DemoClass dc = new DemoClass();
		List<DemoClass> d= new ArrayList();
		dc.setId(1);
		d.add(dc);
		return d;
	}
}
