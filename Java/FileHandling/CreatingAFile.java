package Java.FileHandling;

import java.io.File;
import java.io.IOException;

public class CreatingAFile {
    public static void main(String[] args) {
        File file = new File("Java/FileHandling/demoCreation.txt");

        try {
            if(file.createNewFile()) {  // here new file will be created
                System.out.println("file created");
                file.delete();
                System.out.println("file also delete");
            } else {
                System.out.println("File Already exists");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        
    }
}
