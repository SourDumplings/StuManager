package cz.web.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cz.entity.Student;
import cz.service.StudentService;
import cz.service.impl.StudentServiceImpl;

/**
 * 用于处理学生的添加请求
 */
public class AddServlet extends HttpServlet
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
			
			// 1.获取客户端提交上来的数据
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday"); // 1989-10-18 形式

		//	String hobby = request.getParameter("hobby"); // 这样只能拿到第一个
			String[] h = request.getParameterValues("hobby"); // 这样只能拿到第一个
			String hobbies = Arrays.toString(h);
			String hobby = hobbies.substring(1, hobbies.length() - 1);
			
			String info = request.getParameter("info");
			
			// 2.添加到数据库
			// String -> Date
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sname, gender, phone, hobby, info, date);
			
			StudentService service = new StudentServiceImpl();
			service.insert(student);
			
			// 3.跳转到列表页
			// /*
			// * 这样的跳转是直接跳转到页面上，那么会对这个页面重新翻译一遍，查数据库的request就没有了
			// * 应该做的是再查一次数据库，再装到作用域中再跳转
			// */
			// request.getRequestDispatcher("list.jsp").forward(request, response);
		
			// Servlet不仅可以跳jsp，还可以直接跳到另外一个Servlet
			request.getRequestDispatcher("StudentListServlet").forward(request, response);
		}
		catch (Exception e)
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
