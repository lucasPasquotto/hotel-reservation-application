package view;

import api.HotelResource;
import model.Customer;
import model.IRoom;
import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    private static final HotelResource hotelResource = HotelResource.getInstance();

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Hotel Reservation Application!");
        System.out.println("-------------------------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an Account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("-------------------------------------------");
        System.out.println("Please select a number for the menu option:");

        try {
            do {
                input = scanner.nextLine();

                switch (input.charAt(0)) {
                    case '1':
                        findAndReserveARoom();
                        break;
                    case '2':
                        seeMyReservations();
                        break;
                    case '3':
                        createAnAccount();
                        break;
                    case '4':
                        AdminMenu.adminMenu();
                        break;
                    case '5':
                        System.out.println("Exiting Hotel Reservation Application.");
                        break;
                    default:
                        System.out.println("Please select an valid option.");
                        mainMenu();
                        break;
                }
            } while (input.charAt(0) != '5');
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Please select an valid option.");
            mainMenu();
        }
    }

    public static void findAndReserveARoom() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Check-in date [dd/mm/yyyy]:");
        Date checkInDate = parseDate(scanner.nextLine());

        System.out.println("Check-out date [dd/mm/yyyy]:");
        Date checkOutDate = parseDate(scanner.nextLine());

        Collection<IRoom> avaliableRooms = hotelResource.findARoom(checkInDate, checkOutDate);

        if (avaliableRooms.isEmpty()) {
            System.out.println("We are booked out for this dates, sorry!");
            mainMenu();
        }

        System.out.println("Here is a list of our Available Rooms");
        for (IRoom room : avaliableRooms) {
            System.out.println(room.toString());
        }

        System.out.println("Do you have an account with us? [Y/N]");
        String hasAccount = scanner.nextLine();

        if ("n".equals(hasAccount.toLowerCase().trim())) {
            System.out.println("You must first create an account.");
            createAnAccount();
        } else {
            System.out.println("Enter your email: ");
            String customerEmail = scanner.nextLine();

            if (hotelResource.getCustomer(customerEmail) == null) {
                System.out.println("Account not founded");
                mainMenu();
            }

            System.out.println("\nEnter the room number you like to reserve: ");
            String roomNumber = scanner.nextLine();

            IRoom selectedRoom = hotelResource.getRoom(roomNumber);
            if (avaliableRooms.contains(selectedRoom)) {
                Reservation reservation = hotelResource.bookARoom(customerEmail, selectedRoom, checkInDate, checkOutDate);
                System.out.println(reservation.toString());
            } else {
                System.out.println("\nRoom not available");
                mainMenu();
            };
        }
    }

    private static Date parseDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(date);
        } catch (ParseException exception) {
            System.out.println("Invalid date, restart the reservation");
            mainMenu();
        }
        return null;
    }

    public static void createAnAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name:");
        String lastname = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();

        try {
            hotelResource.createACustomer(firstName, lastname, email);
            System.out.println("Account created !");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getLocalizedMessage());
        } finally {
            mainMenu();
        }
    }

    private static void seeMyReservations() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String customerEmail = scanner.nextLine();

        Collection<Reservation> reservations = hotelResource.getCustomersReservations(customerEmail);

        if (reservations.isEmpty()) {
            System.out.println("There are no reservations for this email.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.toString());
            }
        }

        mainMenu();
    }
}
