
package bookinghotell;


import java.util.Scanner;
public class Menu {

   private static int road;
   private static String input;
   private static final Scanner sc = new Scanner(System.in);
   private static boolean loop = true;
   private ActionMethoods goTo = new ActionMethoods();


   


public  void pickRoom(int x){
        switch (x) {
            case 1:
                System.out.println("Pick a room type:/n"
                        + "1. Room A/n"
                        + "2. Room B/n"
                        + "3. Room C/n");
                input = System.console().readLine();
                road = Integer.parseInt(input);
                System.out.println("");
                switch (road){
                    case 1:
                        display(1, "Bed type: double", "Ac: yes", "free breakfast: yes", "Charge per day: 6000", "Continue: y/n");
                        break;
                    case 2:
                        display(2, "Bed type: single", "Ac: yes", "free breakfast: yes", "Charge per day: 4000", "Continue: y/n");
                        break;
                    case 3:
                        display(3, "Bed type: single", "Ac: no", "free breakfast: no", "Charge per day: 1000", "Continue: y/n");
                        break;
                }            break;
            case 2:
                System.out.println("Pick a room type:/n"
                        + "1. Room A/n"
                        + "2. Room B/n"
                        + "3. Room C/n");
                input = System.console().readLine();
                road = Integer.parseInt(input);
                System.out.println("");
                switch (road){
                    case 1:
                        room(1);
                        break;
                    case 2:
                        room(2);
                        break;
                    case 3:
                        room(3);
                        break;
                }            
            default:
                System.out.println("Pick a room type:/n"
                        + "1. Room A/n"
                        + "2. Room B/n"
                        + "3. Room C/n");
                input = System.console().readLine();
                road = Integer.parseInt(input);
                System.out.println("");
                goTo.SaveType(road);
                // save road as roomType (array) and make a Booking to MySQL.
        }

    
}

public void display(int x, String one, String two, String three, String four, String five){
    System.out.println( one + "/n"
            + two + "/n"
            + three + "/n"
            + four + "/n"
            + five + "/n");
input = System.console().readLine();  
yesNoo(input);
    
}

public void room(int x){
    // get amount of rooms
    System.out.println("Amount of availibal rooms: ");
    System.out.println("conntinue: y/n");
    input = System.console().readLine();
    yesNoo(input);
}
public void yesNoo(String input){
     
    
    if(input.equalsIgnoreCase("y")){
     // save x (as roomType)
     //return to Menu
     customerMenu();

    }else{
        // just return to Main Menu
     customerMenu();
    }
}
public static void listFood(){
    System.out.println("Food Menu:/n");
    // get Food from My SQL and display here.
    // switch case the item Id
    // ask for RoomId
    // save item id and room id to Order MySQL.
    
   
}
public void menuHotell(){
                                      
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

        }while (loop == false );            
        
        } 
            
            public void adminMenu(){
                
                System.out.println("1. Storing Customer Details");
                System.out.println("2. Searching Customer Details");
                System.out.println("3. Upgrade and delete details ");
                System.out.println("4. Booking or upgrading room");
                System.out.println("5. Ordering Food for Particular Room");
                System.out.println("6. Check out for customer and showing bill");
                
                
                switch (sc.nextInt()) {
                    case 1:
                        
                        break;
                    case 2:                      
                          
                        break;                
                    case 3:                      
                          
                        break;                
                    case 4:                      
                          
                        break;                
                    case 5:                      
                          
                        break;                
                    case 6:                      
                          
                        break;                
                    default:
                        System.out.println("Error try again");
                }
            }
            
            
            public void customerMenu(){
             
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
                        listFood(); 
                        break;                
                    case 5:                      
                          
                        break;                
                    case 6:                      
                        System.out.println("System shutting down....");
                        System.exit(0);  
                        break;                
                    default:
                        System.out.println("Error try again");
                }
            }

}
