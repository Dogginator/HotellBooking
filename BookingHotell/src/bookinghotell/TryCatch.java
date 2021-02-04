
package bookinghotell;

import java.util.Scanner;

public class TryCatch {
    private final Scanner sc = new Scanner(System.in);
    private int inputInteger;
   public int tryingInputToInt(String Input){
      while(inputInteger > 1009){
       try{
        inputInteger = Integer.parseInt(Input);
       }catch(Exception e){
           System.out.println("Wrong input Try one more time:");
           String input = sc.nextLine();
       }  
      }
      return inputInteger;
   } 
}
