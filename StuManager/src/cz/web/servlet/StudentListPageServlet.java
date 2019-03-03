package cz.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.entity.PageBean;
import cz.entity.Student;
import cz.service.impl.StudentServiceImpl;

/**
 * 这是用于分页显示学生列表的Servlet
 */
public class StudentListPageServlet extends HttpServlet
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
			// 1.获取需要显示的页码数
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));

			// 2.根据指定的页数获取相应的数据
			StudentServiceImpl service = new StudentServiceImpl();
			PageBean<Student> pageBean = service.findStudentByPage(currentPage);
			
			request.setAttribute("pageBean", pageBean);
			
			// 3.跳转页面
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
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
