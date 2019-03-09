package cz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cz.dao.UserDao;
import cz.dao.impl.UserDaoImpl;
import cz.entity.UserBean;
import cz.util.CookieUtil;

/**
 * Servlet Filter implementation class AutoLoginFilter
 * 
 * 该过滤器的功能是，当会话失效时，可以从未过期的cookie中读取已经登录的信息自动登录
 */
public class AutoLoginFilter implements Filter
{


	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		try
		{
			// 先判断，现在的Session中有没有UserBean
			UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
			if (userBean == null)
			{
				// Session失效，看cookie
				// 1.来请求的时候先从请求里面取出cookie
				Cookie[] cookies = request.getCookies();

				// 2.找出所需的cookie
				Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");

				// 3.如果有cookie表明这个用户以前登录过
				if (cookie != null)
				{
					String value = cookie.getValue();
					String username = value.split("#cz#")[0];
					String password = value.split("#cz#")[1];

					UserBean user = new UserBean();
					user.setUsername(username);
					user.setPassword(password);
					UserDao dao = new UserDaoImpl();
					userBean = dao.login(user);

					// 存到Session中，方便下一次未过期前还可以用
					request.getSession().setAttribute("userBean", userBean);
				}
			}
		}
		finally
		{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

}
