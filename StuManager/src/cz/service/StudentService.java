package cz.service;

import java.sql.SQLException;
import java.util.List;

import cz.entity.Student;

/**   
 * @ClassName:  StudentService   
 * @Description:TODO(这是学生的业务处理规则)   
 * @author: SourDumplings
 * @date:   2019年3月1日 下午3:46:24   
 *     
 * @link: https://github.com/SourDumplings
 */ 
public interface StudentService
{
	/**   
	 * @Title: findAll   
	 * @Description: TODO(查询所有学生)   
	 * @param: @return      
	 * @return: List<Student>      
	 * @throws   
	 */  
	List<Student> findAll() throws SQLException;
	
	/**   
	 * @Title: findStudentById   
	 * @Description: TODO(根据id查询单个学生)   
	 * @param: @param sid
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Student      
	 * @throws   
	 */  
	Student findStudentById(int sid) throws SQLException;
	
	/**   
	 * @Title: searchStudent   
	 * @Description: TODO(根据姓名或者性别模糊查询)   
	 * @param: @param sname
	 * @param: @param gender
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Student>      
	 * @throws   
	 */  
	List<Student> searchStudent(String sname, String gender) throws SQLException;
	
	/**   
	 * @Title: insert   
	 * @Description: TODO(添加学生)   
	 * @param: @param student
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws   
	 */  
	void insert(Student student) throws SQLException;
	
	/**   
	 * @Title: delete   
	 * @Description: TODO(根据sid删除学生)   
	 * @param: @param sid
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws   
	 */  
	void delete(int sid) throws SQLException;
	
	/**   
	 * @Title: update   
	 * @Description: TODO(更新学生信息)   
	 * @param: @param student
	 * @param: @throws SQLException      
	 * @return: void      
	 * @throws   
	 */  
	void update(Student student) throws SQLException;
}
