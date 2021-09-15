package com.meehom.demo_helloworld.controller;

import com.meehom.demo_helloworld.dao.DepartmentDao;
import com.meehom.demo_helloworld.dao.EmployeeDao;
import com.meehom.demo_helloworld.mapper.DepartmentMapper;
import com.meehom.demo_helloworld.mapper.EmployeeMapper;
import com.meehom.demo_helloworld.pojo.Department;
import com.meehom.demo_helloworld.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author meehom
 * @data 2021/9/14 - 13:29
 */
@Controller
public class EmloyeeController {

	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	DepartmentDao departmentDao;

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	DepartmentMapper departmentMapper;

	@RequestMapping("/emps")
	public String list(Model model){
		//Collection<Employee> employees = employeeDao.getAll();
		List<Employee> employees = employeeMapper.queryEmployee();
		model.addAttribute("emps",employees);
		return "emps/list";
	}

	@GetMapping("/emp")
	public String toAddpage(Model model){
		// 查出部门信息
		List<Department> departments = departmentMapper.getAllDepartment();
		//Collection<Department> departments = departmentDao.getDepartment();
		model.addAttribute("departments",departments);
		return "emps/add";

	}

	@PostMapping("/emp")
	public String addEmp(Employee employee){
		// 增加用户信息
		employeeMapper.saveEmployee(employee);
		//employeeDao.save(employee);
		return "redirect:/emps";

	}

	@RequestMapping("/update/{id}")
	public String toUpdate(@PathVariable("id") Integer id, Model model){
		// 查询员工相关信息 根据id
		Employee employee = employeeMapper.getEmployeeById(id);
		//Employee employee = employeeDao.getEmployeeById(id);
		model.addAttribute("emp",employee);
		// 查出部门信息
		List<Department> departments = departmentMapper.getAllDepartment();
		//Collection<Department> departments = departmentDao.getDepartment();
		model.addAttribute("departments",departments);
		return "emps/update";
	}

	@PostMapping("/updateEmp")
	public String updateEmp(Employee employee){
		// 更新用户信息
		employeeMapper.updateEmployee(employee);
		//employeeDao.save(employee);
		return "redirect:/emps";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		employeeMapper.deleteEmployee(id);
		//employeeDao.deleteEmployeeById(id);
		return "redirect:/emps";
	}
}
