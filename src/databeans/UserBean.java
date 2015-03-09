package databeans;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.genericdao.PrimaryKey;

@PrimaryKey("userID")
public class UserBean  {
	private int userID;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	
	public int getUserID()		 { return userID; }
	public String getEmail()	 { return email; }
	public String getFirstName() { return firstName; }
	public String getLastName()  { return lastName; }
	public String getPassword()  { return password; }
	
	public void setUserID(int userID) {	this.userID = userID;}
	public void setEmail(String email){	this.email = email;}
	public void setFirstName (String firstName ) {this.firstName = firstName; }
	public void setLastName (String lastName )  {this.lastName = lastName; }
	public void setPassword (String password )  {this.password = password; }
}
