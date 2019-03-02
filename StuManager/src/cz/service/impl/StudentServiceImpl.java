package cz.service.impl;

import java.sql.SQLException;
import java.util.List;

import cz.dao.impl.StudentDaoImpl;
import cz.entity.Student;
import cz.service.StudentService;

/**   
 * @ClassName:  StudentServiceImpl   
 * @Description:TODO(这是学生的业务实现)   
 * @author: SourDumplings
 * @date:   2019年3月1日 下午3:49:10   
 *     
 * @link: https://github.com/SourDumplings
 */ 
public class StudentServiceImpl implements StudentService
{

	public List<Student> findAll() throws SQLException
	{
		// TODO Auto-generated method stub
		StudentDaoImpl dao = new StudentDaoImpl();
		
		return dao.findAll();
	}

	public void insert(Student student) throws SQLException
	{
		// TODO Auto-generated method stub
		StudentDaoImpl dao = new StudentDaoImpl();
		
		dao.insert(student);
	}

	public void delete(int sid) throws SQLException
	{
		// TODO Auto-generated method stub
		StudentDaoImpl dao = new StudentDaoImpl();
		
		dao.delete(sid);
	}

	public Student findStudentById(int sid) throws SQLException
	{
		// TODO Auto-generated method stub
		StudentDaoImpl dao = new StudentDaoImpl();
		
		return dao.findStudentById(sid);
	}

	public void update(Student student) throws SQLException
	{
		// TODO Auto-generated method stub
		StudentDaoImpl dao = new StudentDaoImpl();
		
		dao.update(student);
	}

	public List<Student> searchStudent(String sname, String gender) throws SQLException
	{
		// TODO Auto-generated method stub
		StudentDaoImpl dao = new StudentDaoImpl();
		
		return dao.searchStudent(sname, gender);
	}
	
	

}
