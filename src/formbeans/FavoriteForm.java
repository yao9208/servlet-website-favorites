package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class FavoriteForm extends FormBean {
	private int userID;
	private String url;
	private String comment;
	private int clickcount;
	



	public int getUserID() {
		return userID;
	}

	public String getUrl() {
		return url;
	}

	public String getComment() {
		return comment;
	}

	public int getClickcount() {
		return 1;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUrl(String s) {
		this.url = trimAndConvert(s,"<>\"");
	}

	public void setComment(String s) {
		this.comment = trimAndConvert(s,"<>\"");
	}

	public void setClickcount(int clickcount) {
		this.clickcount = clickcount;
	}




	public List<String> getValidationErrors() {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		if (url==null||url.equals("")){
			errors.add("URL cannot be empty");
		}
		return errors;
	}
}
