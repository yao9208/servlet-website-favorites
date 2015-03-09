package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class UserForm extends FormBean {
	private String userID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	
	

//	public List<String> getValidationErrors() {
//		List<String> errors = new ArrayList<String>();
//
//		if (userName == null || userName.length() == 0) {
//			errors.add("User Name is required");
//		}
//		
//		return errors;
//	}
}
