package controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import databeans.UserBean;
import model.ItemDAO;
import model.UserDAO;
import model.Model;

public class FavoriteAction extends Action {
	private ItemDAO itemDAO;
	private UserDAO userDAO;

	public FavoriteAction(Model model) {
		itemDAO = model.getItemDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() { return "manage.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        UserBean user = (UserBean) request.getSession(false).getAttribute("user");
        
        
        try {
       		//request.setAttribute("items", itemDAO.getItems(user.getUserID()));
       		request.setAttribute("beans", itemDAO.match(MatchArg.equals("userID", user.getUserID())));
       		request.setAttribute("userList",userDAO.getUsers());
       		return ("favorite.jsp");
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
