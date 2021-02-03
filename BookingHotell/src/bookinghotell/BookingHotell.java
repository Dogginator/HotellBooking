
package bookinghotell;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



import javafx.stage.Stage;

public class BookingHotell {

   private static Stage window;
    Button one, two;
    Scene sceneA;
    Label labelA;
    

    

    public static void main(String[] args) {
        //launch(args);
        Menu go = new Menu();
        go.menuHotell();
    }

}
