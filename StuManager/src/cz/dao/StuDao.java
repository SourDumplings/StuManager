package cz.dao;

import java.util.List;

import cz.entity.Student;

public interface StuDao
{
	/**   
	 * @Title: findAll   
	 * @Description: TODO(查询出所有的学生信息)   
	 * @param: @return      
	 * @return: List<Student>      
	 * @throws   
	 */  
	List<Student> findAll();
}
