package com.meehom.demo_helloworld.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author meehom
 * @data 2021/9/13 - 16:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	private Integer id;
	private String department;
}
