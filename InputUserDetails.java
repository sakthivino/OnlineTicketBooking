package ticketbooking;

import java.util.Scanner;
import ticketbooking.*;

public class InputUserDetails {
	public static Scanner scanner = new Scanner(System.in);

	public void getDetails(UserDetails user, Handler handler) {
		String name, emailId = "", phoneNumber = "";
		System.out.println("Enter your email id");
		emailId = scanner.next();
		if (handler.search(emailId)) {
			System.out.println("your account is already present");

		} else {

			if ((handler.validateEmail(emailId))) {
				System.out.println("Enter valid emailId");
				emailId = scanner.next();
			}

			System.out.println("Enter your name");
			name = scanner.next();
			if ((handler.validateName(name))) {
				System.out.println("Enter valid name");
				name = scanner.next();
			}

			System.out.println("Enter your PhoneNumber");
			phoneNumber = scanner.next();
			if ((handler.validateNumber(phoneNumber))) {
				System.out.println("enter valid phone number");
				phoneNumber = scanner.next();
			}
			setDetails(name, emailId, phoneNumber, user);
		}

	}

	public void setDetails(String name, String emailId, String phoneNumber, UserDetails user) {

		user.setUserName(name);
		user.setEmail(emailId);
		user.setNumber(phoneNumber);
		Handler.addUser(user);

	}

	public void printDetails(UserDetails user) {
		System.out.println("Name " + user.getUserName());
		System.out.println("Email id " + user.getUserEmail());
		System.out.println("Phone number " + user.getNumber());
	}

}