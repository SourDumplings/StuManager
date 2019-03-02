package cz.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.entity.Student;
import cz.service.StudentService;
import cz.service.impl.StudentServiceImpl;

/**
 * 根据id，处理单个学生的更新。查询一个学生的信息，跳转到更新页面。
 */
public class EditServlet extends HttpServlet
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
			// 1.接收id
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			// 2.查询学生数据
			StudentService service = new StudentServiceImpl();
			Student student = service.findStudentById(sid);
			
			// 3.显示该学生的信息
			// 存数据
			request.setAttribute("stu", student);
			// 跳转
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
		catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
