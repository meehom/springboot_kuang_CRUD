package com.meehom.demo_helloworld.mapper;

import com.meehom.demo_helloworld.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author meehom
 * @data 2021/9/15 - 10:27
 */
@Mapper
@Repository
public interface DepartmentMapper {
	List<Department> getAllDepartment();

	// 通过id获得部门
	Department getDepartment(Integer id);

}
