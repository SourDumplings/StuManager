package cz.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.TextUI;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cz.dao.StudentDao;
import cz.entity.Student;
import cz.util.JDBCUtil2;
import cz.util.TextUtil;

/**   
 * @ClassName:  StudentDaoImpl   
 * @Description:TODO(这是StudentDao的实现。针对前面定义的规范所作出的具体的实现)   
 * @author: SourDumplings
 * @date:   2019年3月1日 下午3:15:50   
 *     
 * @link: https://github.com/SourDumplings
 */ 
public class StudentDaoImpl implements StudentDao
{
	public List<Student> findStudentByPage(int currentPage) throws SQLException
	{
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		// 第一个问号：代表一页返回多少个记录，第二个问号：代表跳过前面多少条记录
		return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class),
				PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
	}

	/**   
	 * <p>Title: findAll</p>   
	 * <p>Description: 查询所有学生</p>   
	 * @return   
	 * @throws SQLException 
	 * @see cz.dao.StudentDao#findAll()   
	 */  
	public List<Student> findAll() throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		String sql = "select * from stu";
		List<Student> query = runner.query(sql, new BeanListHandler<Student>(Student.class));
		
		return query;
	}

	public void insert(Student student) throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?)",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo());
	}

	public void delete(int sid) throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		runner.update("delete from stu where sid = ?", sid);
	}

	public Student findStudentById(int sid) throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		Student query = runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class), sid);
		
		return query;
	}

	public void update(Student student) throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		runner.update("update stu set sname = ?, gender = ?, phone = ?, birthday = ?, hobby = ?, info = ? where sid = ?",
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid());
	}

	public List<Student> searchStudent(String sname, String gender) throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		
		/*
		 * 分析：
		 * 1.如果只有姓名:select * from stu where sname = ?
		 * 2.如果只有性别:select * from stu where  = ?
		 * 3.如果两个都有:select * from stu where sname = ? and gender = ?
		 * 4.都有两个都没有：select * from stu
		 *
		 */
		String sql = "select * from stu where 1 = 1";
		
		List<String> list = new ArrayList<String>();
		
//		System.out.println("-----开始执行模糊查询-----");
		
		if (!TextUtil.isEmpty(sname))
		{
			sql = sql + " and sname like ?";
			list.add("%" + sname + "%");
		}
		if (!TextUtil.isEmpty(gender))
		{
			sql = sql + " and gender = ?";
			list.add(gender);
		}
		
/*		System.out.println("收到的数据：");
		for (String string : list)
		{
			System.out.println(string);
		}*/
		
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}

	public int findCount() throws SQLException
	{
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtil2.getDataSource());
		
		// 用于处理平均值、总的函数等
		Long result = (Long)runner.query("select count(*) from stu", new ScalarHandler());
		
		
		return result.intValue();
	}
	
	

}
