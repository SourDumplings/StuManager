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
 * Servlet implementation class UpdateServlate
 */
public class UpdateServlet extends HttpServlet
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
			int sid = Integer.parseInt(request.getParameter("sid"));
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String birthday = request.getParameter("birthday"); // 1989-10-18 形式
			String[] h = request.getParameterValues("hobby"); // 这样只能拿到第一个
			String hobbies = Arrays.toString(h);
			String hobby = hobbies.substring(1, hobbies.length() - 1);
			
			String info = request.getParameter("info");
			
			// 2.更新数据库中的数据
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(sid, sname, gender, phone, hobby, info, date);
			
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			// 3.跳转到列表页
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
