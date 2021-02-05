package bookinghotell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Menu {

    public int road;
    private static String input;
    public static Scanner sc = new Scanner(System.in);
    private static boolean loop = true;
    public static ActionMethoods goTo = new ActionMethoods();
    public static TryCatch trying = new TryCatch();

    public void menuHotell() {

        String passKey = "1234";
        do {
            System.out.println("---Welcome to hotell booking---");
            System.out.println("1. Customer Booking");
            System.out.println("2. Administrator");
            System.out.println("0. Exit program");

            try {
                switch (sc.nextInt()) {
                    case 1:
                        customerMenu();
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("Put in password");
                        String n = sc.nextLine();
                        if (passKey.equals(n)) {
                            adminMenu();
                        } else {
                            menuHotell();
                        }

                        break;
                    case 0:
                        System.out.println("System shutting down....");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error try again");
                }
            } catch (Exception e) {
                System.out.println("Wrong input, try again");
                loop = false;
                sc.nextLine();
            }

        } while (loop == false);

    }

    public void adminMenu() {

        System.out.println("1. Storing Customer Details");
        System.out.println("2. Searching Customer Details");
        System.out.println("3. Upgrade and delete details ");
        System.out.println("4. Booking or upgrading room");
        System.out.println("5. Ordering Food for Particular Room");
        System.out.println("6. Check out for customer and showing bill");

        switch (sc.nextInt()) {
            case 1:
                goTo.storage();
                break;
            case 2:
                goTo.searching();
                break;
            case 3:
                goTo.optionsCostumer();
                break;
            case 4:
                goTo.roomOptions();
                break;
            case 5:
                goTo.foodList();
                break;
            case 6:
                goTo.checkOut();
                break;
            default:
                System.out.println("Error try again");
        }
    }

    public void customerMenu() {

        System.out.println("1.Display room details");
        System.out.println("2. Display room availability");
        System.out.println("3. Book");
        System.out.println("4. Order food ");
        System.out.println("5. Checkout ");
        System.out.println("6. Exit");

        switch (sc.nextInt()) {
            case 1:
                pickRoom(1);
                break;
            case 2:
                pickRoom(2);
                break;
            case 3:
                pickRoom(3);
                break;
            case 4:
                goTo.foodList();
                break;
            case 5:
                goTo.checkOut();
                break;
            case 6:
                System.out.println("System shutting down....");
                System.exit(0);
                break;
            default:
                System.out.println("Error try again");
        }
    }

    public int roomType() {
        sc.nextLine();
        List<String> rooms = new ArrayList<>();
        rooms.add("1. Room A");
        rooms.add("2. Room B");
        rooms.add("3. Room C");
        rooms.forEach(System.out::println);
        input = sc.nextLine();
        road = trying.tryingToInt(input);
        System.out.println("----");

        return road;
    }

    public void roomDetails(int x) {
        x = x - 1;
        /*List<RoomType> types = new ArrayList<>();
        types.add(new RoomType("Bed type: double", "Ac: yes", "free breakfast: yes", "Charge per day: 6000", "Continue: y/n"));
        types.add(new RoomType("Bed type: single", "Ac: yes", "free breakfast: yes", "Charge per day: 4000", "Continue: y/n"));
        types.add(new RoomType("Bed type: single", "Ac: no", "free breakfast: no", "Charge per day: 2000", "Continue: y/n"));*/
        System.out.println("value of x = " + x);
        ArrayList<String> type = new ArrayList<String>();
        type.add("BedType: double\n" + "Ac: yes\n" + "Free breakfast: yes/\n" + "Charge per day: 6000\n");
        type.add("BedType: singel\n" + "Ac: yes\n" + "Free breakfast: yes/\n" + "Charge per day: 4000\n");
        type.add("BedType: singel\n" + "Ac: no\n" + "Free breakfast: no/\n" + "Charge per day: 2000\n");
        System.out.println(type.get(x));
        System.out.println("Continue: Y/N");
        input = sc.nextLine();
        System.out.println("----");
        yesNoo(input);
    }

    public void pickRoom(int x) {
        switch (x) {
            case 1:
                road = roomType();
                roomDetails(road);
                break;
            case 2:
                road = roomType();
                room(road);
                break;
            default:
                roomType();
                input = sc.nextLine();
                road = trying.tryingToInt(input);
                System.out.println("");
                goTo.saveType(road);
                // save road as roomType (array) and make a Booking to MySQL.
                break;
        }
    }

    public void room(int x) {
        // get amount of rooms
        System.out.println("Amount of availibal rooms: ");
        System.out.println("conntinue: y/n");
        input = sc.nextLine();
        System.out.println("");
        yesNoo(input);
    }

    public void yesNoo(String input) {
        if (input.equalsIgnoreCase("y")) {
            //return to Main Menu
            customerMenu();

        } else if (input.equalsIgnoreCase("n")) {
            // just return to Main Menu
            customerMenu();
        } else {
            System.out.println("Wrong input reTry please: 'Continue: y/n?' ");
            input = sc.nextLine();
            yesNoo(input);
        }
    }

}
