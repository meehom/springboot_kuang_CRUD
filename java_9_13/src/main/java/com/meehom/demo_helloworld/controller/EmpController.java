package com.meehom.demo_helloworld.controller;

import com.meehom.demo_helloworld.mapper.EmployeeMapper;
import com.meehom.demo_helloworld.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author meehom
 * @data 2021/9/14 - 22:21
 */
@Controller
public class EmpController {
	@Autowired
	private EmployeeMapper employeeMapper;
	@ResponseBody
	@RequestMapping("/test")
	public List<Employee> query(){
		List<Employee> employees = employeeMapper.queryEmployee();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
		return employees;

	}


}
