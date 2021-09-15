package com.meehom.demo_helloworld.dao;

import com.meehom.demo_helloworld.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author meehom
 * @data 2021/9/13 - 16:42
 */
@Repository
public class DepartmentDao {
	// 定义部门的数据
	private static Map<Integer, Department> departments = null;
	static {
		departments = new HashMap<Integer, Department>();
		departments.put(101,new Department(101,"市场部"));
		departments.put(102,new Department(102,"教务部"));
		departments.put(103,new Department(103,"运营部"));
		departments.put(104,new Department(104,"后勤部"));
		departments.put(105,new Department(105,"教学部"));
	}

	// 获取所有部门信息
	public Collection<Department> getDepartment(){
		return departments.values();
	}

	// 通过id获取部门信息
	public Department getDepartmentById(Integer id){
		return departments.get(id);
	}
}
