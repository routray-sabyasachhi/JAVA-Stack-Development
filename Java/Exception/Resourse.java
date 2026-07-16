package Java.Exception;

import java.io.FileReader;

public class Resourse {
    public static void main(String[] args) {
        try ( FileReader resource = new FileReader("sabya.txt")) {
            // use resource
        } catch (Exception e) {
            // Handled exception
        }

        // Resourse automatically closed here
        /*
        Advantages :
        1> Cleaner code
        2> Automatic resource closure
        3> No need for finally block
         */
    }
}
