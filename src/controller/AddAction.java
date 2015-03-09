package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.mybeans.form.FormBeanException;
import org.mybeans.form.FormBeanFactory;

import databeans.FavoriteBean;
import databeans.UserBean;
import formbeans.FavoriteForm;
import model.ItemDAO;
import model.UserDAO;
import model.Model;

public class AddAction extends Action {
	private FormBeanFactory<FavoriteForm>  itemFormFactory  = FormBeanFactory.getInstance(FavoriteForm.class);
	
	private ItemDAO itemDAO;
	private UserDAO userDAO;

	public AddAction(Model model) {
		itemDAO = model.getItemDAO();
		userDAO = model.getUserDAO();
	}

	public String getName() { return "add.do"; }
    
    public String perform(HttpServletRequest request) {
        List<String> errors = new ArrayList<String>();
        request.setAttribute("errors",errors);
        try {
			request.setAttribute("userList",userDAO.getUsers());
		} catch (RollbackException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
       		// Fetch the items now, so that in case there is no form or there are errors
       		// We can just dispatch to the JSP to show the item list (and any errors)
       		
	        FavoriteForm form = itemFormFactory.create(request);
        	request.setAttribute("form", form);
        	UserBean user = (UserBean) request.getSession(false).getAttribute("user");

	        errors.addAll(form.getValidationErrors());
	        if (errors.size() > 0) {
	        	return "favorite.jsp";
	        }
	        
	        FavoriteBean bean = new FavoriteBean();
	        bean.setClickCount(1);
	        bean.setComment(form.getComment());
	        bean.setUrl(form.getUrl());
	        bean.setUserID(user.getUserID());
	        
	        itemDAO.createAutoIncrement(bean);

       		request.setAttribute("beans", itemDAO.match(MatchArg.equals("userID", user.getUserID())));
       		return "favorite.jsp";

        } catch (RollbackException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        } catch (FormBeanException e) {
        	errors.add(e.getMessage());
        	return "error.jsp";
        }
    }
}
