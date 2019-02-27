package cz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cz.dao.StuDao;
import cz.entity.Student;
import cz.util.JDBCUtil;

public class StuDaoImpl implements StuDao
{

	public List<Student> findAll()
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList(); 
		
		try
		{
			// 1.得到连接对象
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from t_stu";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			// 数据多了用对象装，对象多了用集合装
			while (rs.next())
			{
				Student stu = new Student();
				
				stu.setId(rs.getInt("id"));
				stu.setAge(rs.getInt("age"));
				stu.setAddress(rs.getString("address"));
				stu.setGender(rs.getString("gender"));
				stu.setName(rs.getString("name"));
				
				list.add(stu);
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.release(conn, rs, ps);
		}
		
		
		return list;
	}

}
