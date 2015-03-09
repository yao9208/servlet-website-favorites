package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Model;
import model.ItemDAO;
import model.UserDAO;

import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.UserBean;
import formbeans.UserForm;

/*
 * Looks up the photos for a given "user".
 * 
 * If successful:
 *   (1) Sets the "userList" request attribute in order to display
 *       the list of users on the navbar.
 *   (2) Sets the "photoList" request attribute in order to display
 *       the list of given user's photos for selection.
 *   (3) Forwards to list.jsp.
 */
public class ListAction extends Action {
	private FormBeanFactory<UserForm> formBeanFactory = FormBeanFactory.getInstance(UserForm.class);

	private ItemDAO itemDAO;
	private UserDAO  userDAO;

    public ListAction(Model model) {
    	itemDAO = model.getItemDAO();
    	userDAO  = model.getUserDAO();
	}

    public String getName() { return "list.do"; }

    public String perform(HttpServletRequest request) {
        // Set up the request attributes (the errors list and the form bean so
        // we can just return to the jsp with the form if the request isn't correct)
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        
		try {
            // Set up user list for nav bar
			request.setAttribute("userList",userDAO.getUsers());

			UserForm form = formBeanFactory.create(request);
	    	
			int userID = Integer.parseInt(form.getUserID());
//			if (userName == null || userName.length() == 0) {
//				errors.add("User must be specified");
//				return "error.jsp";
//			}
	
	        // Set up photo list
        	UserBean user = userDAO.read(userID);
        	if (user == null) {
    			errors.add("Invalid User: "+userID);
    			return "error.jsp";
    		}

        	FavoriteBean[] favoriteList = itemDAO.getItems(user.getUserID());
	        request.setAttribute("favoriteList",favoriteList);
	        return "list.jsp";
        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
