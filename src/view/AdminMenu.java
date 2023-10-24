package view;

import api.AdminResource;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    public static AdminResource adminResource = AdminResource.getInstance();

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("\nAdmin menu");
        System.out.println("-------------------------------------------");
        System.out.println("1. See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
        System.out.println("-------------------------------------------");
        System.out.println("Please select a number for the menu option:");

        try {
            input = scanner.nextLine();

            switch (input.charAt(0)) {
                case '1':
                    seeAllCustomers();
                    adminMenu();
                    break;
                case '2':
                    seeAllRooms();
                    adminMenu();
                    break;
                case '3':
                    System.out.println("\nHere is all reservations.");
                    adminResource.displayAllReservations();
                    adminMenu();
                    break;
                case '4':
                    addARoom();
                    adminMenu();
                    break;
                case '5':
                    System.out.println("Back to main menu!");
                    break;
                default:
                    System.out.println("Please select an valid option.");
                    adminMenu();
                    break;
            }
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Please select an valid option.");
            adminMenu();
        }
    }

    private static void addARoom() {
        List<IRoom> rooms = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String addAnotherRoom;
        do {
            System.out.println("\nEnter room number: ");
            String roomNumber = scanner.nextLine();

            System.out.println("Enter price per night: ");
            String price = scanner.nextLine();

            Double roomPrice = 0.0;
            try {
                roomPrice = Double.parseDouble(price);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input for price");
                addARoom();
            }

            System.out.println("Enter room type (1 for a single bed, 2 for a double bed): ");
            String type = scanner.nextLine();

            RoomType roomType = null;
            if ("1".equals(type)) {
                roomType = RoomType.SINGLE;
            } else if ("2".equals(type)) {
                roomType = RoomType.DOUBLE;
            } else {
                System.out.println("Invalid input, try to select 1 or 2");
                addARoom();
            }

            Room room = new Room(roomNumber, roomPrice, roomType);
            rooms.add(room);

            System.out.println("\nWould you like to add another room? [Y/N]");
            addAnotherRoom = scanner.nextLine();
        } while ("y".equals(addAnotherRoom.toLowerCase().trim()));

        adminResource.addRoom(rooms);
    }

    private static void seeAllRooms() {
        Collection<IRoom> rooms = adminResource.getAllRooms();
        if (rooms.isEmpty()) {
            System.out.println("No rooms founded.");
        } else {
            for (IRoom room : rooms) {
                System.out.println(room.toString());
            }
        }
    }

    private static void seeAllCustomers() {
        Collection<Customer> customers = adminResource.getAllCustomers();
        if (customers.isEmpty()) {
            System.out.println("No customers founded");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        }
    }
}
