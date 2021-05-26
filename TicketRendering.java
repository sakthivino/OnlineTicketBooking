package ticketbooking;

import java.util.*;

import com.sun.tools.javac.code.Symbol.ClassSymbol;

import ticketbooking.*;

public class TicketRendering {

	HashMap<Integer, String> movie = new HashMap<>() {
		{
			put(1, "  KARNAN");
			put(2, "  SULTHAN");
		}
	};

	public void printListOfMovies(UserDetails user, Handler handler) {
		System.out.println(" List of Movies  ");
		System.out.println("S.NO   MOVIE NAME");
		for (Map.Entry<Integer, String> it : movie.entrySet())
			System.out.println(it.getKey() + " " + it.getValue());

		System.out.println("enter your choice");
		int choice = InputUserDetails.scanner.nextInt();
		String movieName = "";

		switch (choice) {
		case 1:
			System.out.println(" 1  KARNAN  100");
			movieName = "KARNAN";
			break;
		case 2:
			System.out.println("2  SULTHAN    100");
			movieName = "SULTHAN";
			break;
		default:
			System.out.println("enter valid number");
			choice = InputUserDetails.scanner.nextInt();
			break;

		}
		bookingTickets(movieName, user, handler);
	}

	public void bookingTickets(String movieName, UserDetails user, Handler handler) {

		System.out.println("enter no of seats");
		int seats = InputUserDetails.scanner.nextInt();
		ArrayList<Integer> seatNumbers = new ArrayList<>();

		if ((MovieConstants.valueOf(movieName).noOfSeats - seats) < 0) {
			System.out.println("There is not enough seats for booking " + MovieConstants.valueOf(movieName));
			System.out.println(MovieConstants.valueOf(movieName).noOfSeats);

		} else {

			for (int i = 1; i <= seats; i++) {
				System.out.println("enter seat number " + i);
				int n = InputUserDetails.scanner.nextInt();

				if (handler.isSeatNoAvailable(movieName, n)) {

					seatNumbers.add(n);
				}

				else {

					i = i - 1;
				}

			}
			MovieConstants.valueOf(movieName).noOfSeats -= seats;

		}
		handler.storeSeats(MovieConstants.valueOf(movieName), seatNumbers);

	}

	public void printTicketDetails(UserDetails user, Handler handler) {

		HashMap<MovieConstants, ArrayList<Integer>> value = handler.searchInput(user.getUserName());

		System.out.println("Your Movie name and Ticket Numbers");
		if (handler.search(user.getUserEmail())) {
			for (Map.Entry<MovieConstants, ArrayList<Integer>> it : value.entrySet()) {

				System.out.println(it.getKey() + " " + it.getValue());
			}
		}
	}

	public void availableTickets() {
		System.out.println();
		System.out.println("TOTAL NO OF AVAILABLE TICKETS");
		System.out.println("Available tickets for " + MovieConstants.KARNAN + " " + MovieConstants.KARNAN.noOfSeats);
		System.out.println("Available tickets for " + MovieConstants.SULTHAN + " " + MovieConstants.SULTHAN.noOfSeats);
		System.out.println();
	}

}
