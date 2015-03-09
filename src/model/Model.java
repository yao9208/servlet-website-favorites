package model;

import javax.servlet.ServletConfig;

import databeans.UserBean;
import databeans.FavoriteBean;

import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;

public class Model {

	private UserDAO  userDAO;
	private ItemDAO  itemDAO;

	public Model(ServletConfig config) throws ServletException, RollbackException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL    = config.getInitParameter("jdbcURL");
			
			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			userDAO  = new UserDAO("mingyao_user", pool);
			itemDAO  = new ItemDAO("mingyao_favorite", pool);
			if (userDAO.getCount() == 0) {
				   // create the users and favorites
				   
				 createNewUsers1(userDAO, itemDAO, new info("potus@whitehouse.gov","Barack","Obama","1234"));
				 createNewUsers2(userDAO, itemDAO, new info("mingyao@andrew.cmu.edu","Ming","Yao","1234"));
				 createNewUsers3(userDAO, itemDAO, new info("asdf@cmu.edu","Chris","Wang","1234"));
				   // etc, etc
				}

		} catch (DAOException e) {
			throw new ServletException(e);
		}
	}
	
	public void createNewUsers1(UserDAO userDAO, ItemDAO itemDAO, info a) throws RollbackException{
		UserBean u1 = new UserBean();
		   u1.setEmail(a.email);
		   u1.setFirstName(a.firstName);
		   u1.setLastName(a.lastName);
		   u1.setPassword(a.password);
		   userDAO.createAutoIncrement(u1);
		 
		   FavoriteBean f1 = new FavoriteBean();
		   f1.setUrl("http://www.cmu.com");
		   f1.setComment("cmu");
		   f1.setClickCount(3);
		   f1.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f1);
		   
		   FavoriteBean f4 = new FavoriteBean();
		   f4.setUrl("http://www.google.com");
		   f4.setComment("goolge");
		   f4.setClickCount(6);
		   f4.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f4);
		   
		   FavoriteBean f2 = new FavoriteBean();
		   f2.setUrl("http://www.whitehouse.gov");
		   f2.setComment("My home");
		   f2.setClickCount(3);
		   f2.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f2);
		   
		   FavoriteBean f3 = new FavoriteBean();
		   f3.setUrl("http://www.baidu.com");
		   f3.setComment("baidu");
		   f3.setClickCount(4);
		   f3.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f3);
	}
	public void createNewUsers2(UserDAO userDAO, ItemDAO itemDAO, info a) throws RollbackException{
		UserBean u1 = new UserBean();
		   u1.setEmail(a.email);
		   u1.setFirstName(a.firstName);
		   u1.setLastName(a.lastName);
		   u1.setPassword(a.password);
		   userDAO.createAutoIncrement(u1);
		 
		   FavoriteBean f1 = new FavoriteBean();
		   f1.setUrl("http://www.apple.com");
		   f1.setComment("apple");
		   f1.setClickCount(2);
		   f1.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f1);
		   
		   FavoriteBean f4 = new FavoriteBean();
		   f4.setUrl("http://www.yahoo.com");
		   f4.setComment("yahoo");
		   f4.setClickCount(1);
		   f4.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f4);
		   
		   FavoriteBean f2 = new FavoriteBean();
		   f2.setUrl("http://www.ebay.com");
		   f2.setComment("ebay");
		   f2.setClickCount(2);
		   f2.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f2);
		   
		   FavoriteBean f3 = new FavoriteBean();
		   f3.setUrl("http://www.taobao.com");
		   f3.setComment("taobao");
		   f3.setClickCount(5);
		   f3.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f3);
	}
	public void createNewUsers3(UserDAO userDAO, ItemDAO itemDAO, info a) throws RollbackException{
		UserBean u1 = new UserBean();
		   u1.setEmail(a.email);
		   u1.setFirstName(a.firstName);
		   u1.setLastName(a.lastName);
		   u1.setPassword(a.password);
		   userDAO.createAutoIncrement(u1);
		 
		   FavoriteBean f1 = new FavoriteBean();
		   f1.setUrl("http://www.linkedin.com");
		   f1.setComment("linkedin");
		   f1.setClickCount(2);
		   f1.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f1);
		   
		   FavoriteBean f4 = new FavoriteBean();
		   f4.setUrl("http://www.ehow.com");
		   f4.setComment("eHow");
		   f4.setClickCount(1);
		   f4.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f4);
		   
		   FavoriteBean f2 = new FavoriteBean();
		   f2.setUrl("http://www.facebook.com");
		   f2.setComment("facebook");
		   f2.setClickCount(4);
		   f2.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f2);
		   
		   FavoriteBean f3 = new FavoriteBean();
		   f3.setUrl("http://www.twitter.com");
		   f3.setComment("twitter");
		   f3.setClickCount(2);
		   f3.setUserID(u1.getUserID());
		   itemDAO.createAutoIncrement(f3);
	}
	class info{
		String email;
		String firstName;
		String lastName;
		String password;
		public info(String a, String b, String c, String d){
			email=a;
			firstName=b;
			lastName=c;
			password=d;
		}
	}
	

	public UserDAO  getUserDAO()  { return userDAO;  }
	public ItemDAO  getItemDAO()  {return  itemDAO; }
	
}
