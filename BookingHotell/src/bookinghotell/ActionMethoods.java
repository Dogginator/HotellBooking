
package bookinghotell;

import java.util.Scanner;

public class ActionMethoods {
  private final Scanner sc = new Scanner(System.in);
  private String input, inputInt, sendOrder, room;
  private int integer, integerInput, road;
  private final TryCatch trying = new TryCatch();
  private final Menu goTo = new Menu();
    
  public void saveType(int x){
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
        integer = trying.roomCheck(input);
        sendOrder = "";
        MySQL.mySQL(sendOrder);
        System.out.println("name please: ");
        input = sc.nextLine();
        System.out.println("phone number please:");
        inputInt = sc.nextLine();
        sendOrder = "INSERT INTO Costumer(Name, Phone) VALUE(" + input + ", " + inputInt + ");";
        MySQL.mySQL(sendOrder);
        // not Done Yet
        
       
    }
    public void foodList(){ // DONE
       System.out.println("Food Menu:/n");
       sendOrder = "SELECT * FROM Food";
       MySQL.listAll(sendOrder);
       System.out.println("Room Nr: ");   
       input = sc.nextLine();
       integer = trying.roomCheck(input);
       System.out.println("food Item Id: ");
       input = sc.nextLine();
       integerInput = trying.tryingInput(input);
       sendOrder = "INSERT INTO Order(RoomID, ItemID) VALUE(" + integer + "," + integerInput + ");";
       MySQL.mySQL(sendOrder);
       goTo.customerMenu();
    
    }
    public void searching(){ // DONE
        System.out.println("");
        System.out.println("Costumer search"
                + "1. Full Costumer List/n"
                + "2. Search with name:/n"
                + "3. Search with CostumerID:/n");
        input = sc.nextLine();
        road = trying.tryingToInt(input);
        switch(road){
            case 1:
                System.out.println("Displaying Full List:");
                sendOrder = "SELECT * FROM Costumer";
                System.out.println("Searching...");
                MySQL.listAll(sendOrder);
                System.out.println("-----");
                goTo.adminMenu();
                break;
            case 2:
                System.out.println("name of the Costumer: ");
                input = sc.nextLine();
                sendOrder = "SELECT * FROM Costumer WHERE name = %" + input + ";";
                System.out.println("Searching...");
                MySQL.listAll(sendOrder);
                System.out.println("-----");
                goTo.adminMenu();
                break;
            default:
                System.out.println("Id of the Costumer: ");
                input = sc.nextLine();
                integer = trying.tryingInput(input);
                sendOrder = "SELECT * FROM Costumer WEHERE CostumerID = " + integer + ";";
                System.out.println("Searching...");
                MySQL.listAll(sendOrder);
                System.out.println("-----");
                goTo.adminMenu();
                break;
        }
    }
    
    public void storage(){ // DONE
        System.out.println("Name of new Costumer: ");
        input = sc.nextLine();
        System.out.println("Phone number: ");
        inputInt = sc.nextLine();
        sendOrder = "INSERT INTO Costumer(name, Phone) VALUE("+ input+","+inputInt+");";
        MySQL.mySQL(sendOrder);
        System.out.println("Sucsses!");
        goTo.adminMenu();
        

    }
    
    public void optionsCostumer(){ // DONE
        System.out.println("Options on Costumer"
                + "1. Update a Costumer"
                + "2. Remove a Costumer");
        input = sc.nextLine();
        road = trying.tryingToInt(input);

        switch(road){
            case 1:
                System.out.println("What Would you Like to Update:/n"
                        + "1. name?/n"
                        + "2. Phone number?/n");
                        input = sc.nextLine();
                        road = trying.tryingToInt(input);
                        switch(road){
                            case 1:                                 
                                sendOrder = "SELECT * FROM Costumer";
                                MySQL.listAll(sendOrder);
                                System.out.println("New Name: ");
                                input = sc.nextLine();
                                System.out.println("CostumerID for Update: ");
                                inputInt = sc.nextLine();
                                integer = trying.tryingInput(inputInt);
                                sendOrder = "UPDATE Costumer SET Name = " + input + " WHERE CostumerID = " + integer + ";";
                                MySQL.mySQL(sendOrder);
                                System.out.println("Sucsses!");
                                goTo.adminMenu();
                                break;
                            default:
                                sendOrder = "SELECT * FROM Costumer";
                                MySQL.listAll(sendOrder);
                                System.out.println("New Phone number: ");
                                input = sc.nextLine();
                                System.out.println("CostumerID for Update: ");
                                inputInt = sc.nextLine();
                                integer = trying.tryingInput(inputInt);
                                sendOrder = "UPDATE Costumer SET Phone = " + input +" WHERE CostumerID = " + integer + ";";
                                MySQL.mySQL(sendOrder);
                                System.out.println("Sucsses!");
                                goTo.adminMenu();
                                break;
                        }
                break;
            default:
                sendOrder = "SELECT * FROM Costumer";
                MySQL.listAll(sendOrder);
                System.out.println("CostumerID for Removal: ");
                input = sc.nextLine();
                integer = trying.tryingInput(input);
                sendOrder = "DELETE FROM Costumer WHERE CostumerID = " + integer + ";";
                MySQL.mySQL(sendOrder);
                System.out.println("Done!");
                goTo.adminMenu();
                break;
        }
      // update and Delete Funktions  
    }
    
    public void roomOptions(){
        
        // Upgrade or Booking Room
       
    }
    
    public void checkOut(){
        // Check out..
    }
}
