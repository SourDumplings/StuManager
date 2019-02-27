package cz.dao;

/**   
 * @ClassName:  UserDao   
 * @Description:TODO(该dao定义了对用户表的访问规则)   
 * @author: SourDumplings
 * @date:   2019年2月25日 下午6:14:50   
 *     
 * @link: https://github.com/SourDumplings
 */ 
public interface UserDao
{
	/**   
	 * @Title: login   
	 * @Description: TODO(登录 。这里简单就返回 一个Boolean类型，成功或者失败。
	 * 但是在开发的时候，登录的方法，一旦成功。这里应该返回该用户的个人信息
	 * @param: username password      
	 * @return: true表示登录成功 ，返回false表明登录失败
	 * @throws   
	 *
	 */  
	boolean login(String username, String password);
}
