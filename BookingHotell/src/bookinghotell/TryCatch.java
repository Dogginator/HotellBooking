package bookinghotell;

import java.util.Scanner;

public class TryCatch {

    Scanner sc = new Scanner(System.in);
    int inputInteger = 0;
    boolean loop = true;

    public int tryingToInt(String input) {
        do {
            loop = true;
            try {
                inputInteger = Integer.parseInt(input);
                if (inputInteger <= 0) {
                    throw new Exception("Input mindre än 1!");
                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Error fel input, prova igen");
                input = sc.nextLine();
                loop = false;

            }

        } while (loop == false);
        return inputInteger;
    }

    public int roomCheck(String input) {
        do {
            loop = true;
            try {
                inputInteger = Integer.parseInt(input);
                if (inputInteger <= 1009) {
                    throw new Exception("Input mindre än 1010!");
                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Error fel input, prova igen");
                input = sc.nextLine();
                loop = false;

            }

        } while (loop == false);
        return inputInteger;
    }

    public int tryingInput(String input) {
        do {
            loop = true;
            try {
                inputInteger = Integer.parseInt(input);
                if (inputInteger <= 0) {
                    throw new Exception("Input mindre än 1!");
                }

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Error fel input, prova igen");
                input = sc.nextLine();
                loop = false;

            }

        } while (loop == false);
        return inputInteger;
    }
}
