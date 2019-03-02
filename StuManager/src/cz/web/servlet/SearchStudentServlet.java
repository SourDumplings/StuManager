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
 * Servlet implementation class SearchStudentServlet
 */
public class SearchStudentServlet extends HttpServlet
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
			request.setCharacterEncoding("UTF-8");
			
			// 1.取到查询所需的关键数据：姓名、性别
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			
			// 2.找service去查询
			StudentServiceImpl service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(sname, gender);
			
			// 3.跳转界面
			request.setAttribute("list", list);
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
