package ticketbooking;

import java.util.Scanner;

public class UserDetails {

	private String userName;
	private String emailId;
	private String phNumber;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getUserEmail() {
		return this.emailId;
	}

	public void setEmail(String emailId) {
		this.emailId = emailId;
	}

	public String getNumber() {
		return this.phNumber;
	}

	public void setNumber(String phNumber) {
		this.phNumber = phNumber;
	}

}
