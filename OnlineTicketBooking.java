package ticketbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class OnlineTicketBooking {

	public void launch() {

		InputUserDetails inputUserDetails = new InputUserDetails();
		TicketRendering ticketRendering = new TicketRendering();
		UserDetails user1 = new UserDetails();
		Handler handler = new Handler();
		boolean again = true;

		while (again) {
			inputUserDetails.getDetails(user1, handler);
			inputUserDetails.printDetails(user1);
			ticketRendering.printListOfMovies(user1, handler);
			ticketRendering.printTicketDetails(user1, handler);
			ticketRendering.availableTickets();
			handler.printTotalMoviesSeats( user1, handler);
			System.out.println("do u want to continue ? (Y/N)");
			String ch = inputUserDetails.scanner.next();
			again = ch.equalsIgnoreCase("y") ? true : false;

		}

	}

	public static void main(String... args) {
		OnlineTicketBooking onlineTicketBooking = new OnlineTicketBooking();
		onlineTicketBooking.launch();

	}

}
