package view;

import java.util.Objects;
import java.util.Scanner;

public class MainMenu {

    public static void start() {
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
                        System.out.println("Exiting Hotel Reservation Application.");
                        break;
                    default:
                        System.out.println("Please select an valid option.");
                        start();
                        break;
                }
            } while (input.charAt(0) != '5');
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Please select an valid option.");
            start();
        }
    }
}
