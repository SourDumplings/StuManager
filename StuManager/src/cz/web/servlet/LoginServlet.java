package cz.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cz.dao.UserDao;
import cz.dao.impl.UserDaoImpl;
import cz.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
/**
 * @ClassName: LoginServlet
 * @Description:TODO(这是用于处理登录的Servlet)
 * @author: SourDumplings
 * @date: 2019年2月25日 下午5:45:38
 * 
 * @link: https://github.com/SourDumplings
 */
public class LoginServlet extends HttpServlet
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
			// 提交的数据有可能有中文
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			UserBean user = new UserBean();

			// 1.获取客户端提交的信息
			/*String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("username:" + username + ", password:" + password);*/
			Map<String, String[]> map = request.getParameterMap();
			BeanUtils.populate(user, map);
			
			String auto_login = request.getParameter("auto_login");

			// 2.去数据库访问有没有这个用户：去访问dao,看看是否满足登录
			UserDao dao = new UserDaoImpl();
			UserBean userBean = dao.login(user);
			
			// 3.根据dao返回结果，做出响应
			if (userBean != null)
			{
				if (auto_login != null && auto_login.equals("on"))
				{
					// 页面提交上来的时候，是否选择了自动登录
					Cookie cookie = new Cookie("auto_login", userBean.getUsername() + "#cz#" + userBean.getPassword());
					cookie.setMaxAge(60 * 60); // 设置Cookie为1h有效期
					response.addCookie(cookie);
					cookie.setPath(request.getContextPath());
				}
				// 登录成功，进入首页
				request.getSession().setAttribute("userBean", userBean);
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.getWriter().write("登录失败！用户名或者密码错误！");
			}
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
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
