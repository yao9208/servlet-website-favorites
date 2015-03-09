package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class RegisterForm extends FormBean {
	private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String button;
    private String confirm;
	
  
    public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm.trim();
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public String getButton() {
		return button;
	}
	public void setEmail(String s) {
		this.email = trimAndConvert(s,"<>\"");
	}
	public void setFirstName(String s) {
		this.firstName = trimAndConvert(s,"<>\"");
	}
	public void setLastName(String s) {
		this.lastName = trimAndConvert(s,"<>\"");
	}
	public void setPassword(String password) {
		this.password = password.trim();
	}
	public void setButton(String button) {
		this.button = button.trim();
	}


	public boolean isPresent()   { return button != null; }

    public List<String> getValidationErrors() {
        List<String> errors = new ArrayList<String>();

        if (email == null || email.length() == 0) errors.add("User Name is required");
        if (firstName == null || firstName.length() == 0) errors.add("User firstName is required");
        if (lastName == null || lastName.length() == 0) errors.add("User lastName is required");
        if (password == null || password.length() == 0) errors.add("Password is required");
        if (confirm == null || confirm.length() == 0) errors.add("Password confirm is required");
        //if (button == null) errors.add("Button is required");

        

        //if (!button.equals("Login") && !button.equals("Register")) errors.add("Invalid button");
       // if (userName.matches(".*[<>\"].*")) errors.add("User Name may not contain angle brackets or quotes");
        if (!password.equals(confirm)) {
			errors.add("Passwords are not the same");
		}
        if (errors.size() > 0) return errors;
        return errors;
    }
}
