package view;

import java.util.Scanner;

public class AdminMenu {

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Hotel Reservation Application!");
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
                    System.out.println("Item 1.");
                    break;
                case '2':
                    System.out.println("Item 2.");
                    break;
                case '3':
                    System.out.println("Item 3.");
                    break;
                case '4':
                    System.out.println("Item 4.");
                    break;
                case '5':
                    System.out.println("Option 5 Admin menu.");
                    MainMenu.mainMenu();
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
}
