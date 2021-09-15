package com.meehom.demo_helloworld.dao;

import com.meehom.demo_helloworld.pojo.Department;
import com.meehom.demo_helloworld.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author meehom
 * @data 2021/9/13 - 17:00
 */
@Repository
public class EmployeeDao {
	private static Map<Integer, Employee> employees;

	@Autowired
	private DepartmentDao departmentDao;

	static {
		employees = new HashMap<Integer, Employee>();
		employees.put(1001, new Employee(1001, "AA", "A123@QQ.COM", 0, new Department(101,"市场部")));
		employees.put(1002, new Employee(1002, "BB", "B123@QQ.COM", 1, new Department(102,"教务部")));
		employees.put(1003, new Employee(1003, "CC", "C123@QQ.COM", 0, new Department(103,"运营部")));
		employees.put(1004, new Employee(1004, "DD", "D123@QQ.COM", 1, new Department(104,"后勤部")));
		employees.put(1005, new Employee(1005, "EE", "E123@QQ.COM", 0, new Department(105,"教学部")));
	}

	// 主键自增
	private static Integer initId = 1006;

	// 增加一个员工
	public void save(Employee employee){
		if (employee.getId() == null){
			employee.setId(initId++);
		}
		employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
		employees.put(employee.getId(),employee);
	}

	// 查询全部员工
	public Collection<Employee> getAll(){
		return employees.values();
	}

	// 通过id查询员工
	public  Employee getEmployeeById(Integer id){
		return employees.get(id);
	}

	// 删除一个员工
	public void deleteEmployeeById(Integer id){
		employees.remove(id);
	}

}
