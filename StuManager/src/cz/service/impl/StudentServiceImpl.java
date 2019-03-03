package cz.service.impl;

import java.sql.SQLException;
import java.util.List;

import cz.dao.StudentDao;
import cz.dao.impl.StudentDaoImpl;
import cz.entity.PageBean;
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

	public PageBean<Student> findStudentByPage(int currentPage) throws SQLException
	{
		// TODO Auto-generated method stub
		// 封装分页的该页数据
		PageBean<Student> pageBean = new PageBean<Student>();
		StudentDaoImpl dao = new StudentDaoImpl();
		int pageSize = StudentDao.PAGE_SIZE;
		
		pageBean.setCurrentPage(currentPage); // 设置当前页
		pageBean.setPageSize(pageSize); // 设置每页显示多少记录
		List<Student> list = dao.findStudentByPage(currentPage); // 设置这一页显示的学生数据
		pageBean.setList(list);
		
		// 总的记录数和总的页数
		int count = dao.findCount();
		pageBean.setTotalSize(count); // 设置总的记录数
		// 总页数
		pageBean.setTotalPage(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		
		return pageBean;
	}
	
	

}
