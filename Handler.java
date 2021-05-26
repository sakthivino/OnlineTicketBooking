package ticketbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {

	private static HashMap<UserDetails, HashMap<MovieConstants, ArrayList<Integer>>> userTicketMap = new HashMap<>();
	static HashMap<MovieConstants, ArrayList<Integer>> bookedTickets = new HashMap<>();

	public static void addUser(UserDetails user) {

		userTicketMap.put(user, bookedTickets);
	}

	public void storeSeats(MovieConstants movieName, ArrayList<Integer> seatNumbers) {
		bookedTickets.put(movieName, seatNumbers);
	}

	public boolean isSeatNoAvailable(String movies, int seatNo) {
		if (seatNo <= 100) {
			if (MovieConstants.valueOf(movies).availableSeats[seatNo - 1] == false) {
				MovieConstants.valueOf(movies).availableSeats[seatNo - 1] = true;
				return true;
			} else {
				System.out.println("The seat is already booked");
				System.out.println("Please book another seat");
			}
		} else {
			System.out.println("you did not give seat number above 100");
			return false;
		}
		return false;

	}

	public boolean validateName(String name) {
		String regex = "[a-z A-Z]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		boolean matchFound = matcher.find();
		if (!matchFound) {
			return true;
		}
		return false;

	}

	public boolean validateEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean matchFound = matcher.find();
		if (!matchFound) {
			return true;
		}
		return false;

	}

	public boolean validateNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean matchFound = matcher.find();
		if (!matchFound)

			return true;

		return false;
	}

	public boolean search(String emailId) {
		for (Map.Entry<UserDetails, HashMap<MovieConstants, ArrayList<Integer>>> it : userTicketMap.entrySet()) {
			if (it.getKey().getUserEmail().equalsIgnoreCase(emailId))
				return true;
		}
		return false;

	}

	public HashMap<MovieConstants, ArrayList<Integer>> searchInput(String name) {
		for (Map.Entry<UserDetails, HashMap<MovieConstants, ArrayList<Integer>>> it : userTicketMap.entrySet()) {
			if (it.getKey().equals(name))
				return bookedTickets;
		}
		return bookedTickets;

	}

	public void printTotalMoviesSeats(UserDetails user, Handler handler) {
		System.out.println("Karnan Booked Tickets");
		for(int i = 0; i < 100; i++) {
			if(MovieConstants.KARNAN.availableSeats[i] == true)
			System.out.print(i+ 1);
		}
		System.out.println();
		System.out.println("sulthan Booked Tickets");
		for(int i = 0; i < 100; i++) {
			if(MovieConstants.SULTHAN.availableSeats[i] == true)
			System.out.print(i+ 1);
		}
	}

}
