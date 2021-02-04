
package bookinghotell;

import java.util.Scanner;

public class TryCatch {
    private final Scanner sc = new Scanner(System.in);
    private int inputInteger;
    
   public int tryingToInt(String input){
      while(inputInteger < 0 && inputInteger > 4){  
       try{
        inputInteger = Integer.parseInt(input);
       }catch(Exception e){
           System.out.println(e);
           System.out.println("Wrong input Try one more time:");
           input = sc.nextLine();
       }  
      }
      return inputInteger;
   }
   
   public int roomCheck(String input){
       while(inputInteger < 1009){
       try {
           inputInteger = Integer.parseInt(input);
       }catch(Exception e){
           System.out.println(e);
           System.out.println("Wrong input Try one more time:");
           input = sc.nextLine();
       }
       
            }
       return inputInteger;
   }
   
   public int tryingInput(String input){
       while (inputInteger  < 0){
           try{
               inputInteger = Integer.parseInt(input);
           }catch(Exception e){
               System.out.println(e);
               System.out.println("Wrong input Try one more time:");
               input = sc.nextLine();
           }
       }
       return inputInteger;
   }
}
