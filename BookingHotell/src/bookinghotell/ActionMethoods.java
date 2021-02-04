
package bookinghotell;

import java.util.Scanner;

public class ActionMethoods {
  private final Scanner sc = new Scanner(System.in);
  private String input, inputInt, sendOrder, room;
  private int integer;
  private TryCatch trying = new TryCatch();
    public void SaveType(int x){
        switch(x){
            case 1:
                room = "Room A";
                break;
            case 2:
                room = "Room B";
                break;
            default:
                room = "Room C";
                break;
        }
        sendOrder = "SELECT * FROM Room WHERE RoomType = " + room +";";
        System.out.println("pick one of the following room numbers:");
        MySQL.listAll(sendOrder);
        input = sc.nextLine();
        integer = trying.tryingInputToInt(input);
        
        System.out.println("name please: ");
        input = sc.nextLine();
        System.out.println("phone number please:");
        inputInt = sc.nextLine();
        sendOrder = "INSERT TO Costumer(Name, Phone)/n" + "VALUE(" + input + ", " + inputInt + ");";
        MySQL.mySQL(sendOrder);
       
    }
}
