package com.meehom.demo_helloworld.mapper;

import com.meehom.demo_helloworld.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author meehom
 * @data 2021/9/14 - 22:10
 */
@Mapper
@Repository
public interface EmployeeMapper {
	List<Employee> queryEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(Integer id);
	void updateEmployee(Employee employee);
	void deleteEmployee(Integer id);
}
