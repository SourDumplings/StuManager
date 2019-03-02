package cz.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.entity.Student;
import cz.service.impl.StudentServiceImpl;

/**
 * 负责查询所有的学生信息，然后呈现到list.jsp页面上
 */
public class StudentListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		try
		{
			// 1.查询出所有的学生
			StudentServiceImpl service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			
			// 2.将数据存储在作用域中
			request.setAttribute("list", list);
			
			// 3.跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
