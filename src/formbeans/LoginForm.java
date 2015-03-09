package formbeans;

import java.util.ArrayList;
import java.util.List;


import org.mybeans.form.FormBean;

public class LoginForm extends FormBean {
	private String email;
    private String password;
    //private String button;
	
    public String getEmail()  { return email; }
    public String getPassword()  { return password; }
    
    public void setEmail(String s) { email = trimAndConvert(s,"<>\""); }
    public void setPassword(String s) { password = trimAndConvert(s,"<>\""); }
   // public String getButton()    { return button;   }
    
   // public boolean isPresent()   { return button != null; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (email == null || email.length() == 0) errors.add("User Email is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
    //    if (button == null) errors.add("Button is required");

        if (errors.size() > 0) return errors;

     //   if (!button.equals("Login") && !button.equals("Register")) errors.add("Invalid button");
    	
        return errors;
    }
}