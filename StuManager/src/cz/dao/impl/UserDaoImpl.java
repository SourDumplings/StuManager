package cz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.dao.UserDao;
import cz.util.JDBCUtil;

public class UserDaoImpl implements UserDao
{
	public boolean login(String username, String password)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			// 1.得到连接对象
			conn = JDBCUtil.getConnection();
			
			String sql = "select * from t_user where username=? and password=?";
			
			// 2.创建ps对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			// 3.开始执行
			rs = ps.executeQuery();
			
			// 如果能够成功移到下一条记录，表明有这个用户，会返回true
			return rs.next();
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
		
		
		return false;
	}

}
