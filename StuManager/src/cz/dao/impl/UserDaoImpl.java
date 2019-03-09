package cz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cz.dao.UserDao;
import cz.entity.UserBean;
import cz.util.JDBCUtil2;

public class UserDaoImpl implements UserDao
{
	public UserBean login(UserBean user)
	{
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try
		{
			// 1.得到连接对象
			conn = JDBCUtil2.getConnection();
			
			String sql = "select * from t_user where username=? and password=?";
			
			// 2.创建ps对象
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			// 3.开始执行
			rs = ps.executeQuery();
			
			// 如果能够成功移到下一条记录，表明有这个用户，会返回true
			if (rs.next())
			{
				return user;
			}
			else
				return null;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil2.release(conn, rs, ps);
		}
		
		
		return null;
	}

}
