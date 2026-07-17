package Java.FileHandling;

import java.io.File;
import java.io.IOException;

public class CreateNewDirectory {
    public static void main(String[] args) {
        File makedir = new File("Java/FileHandling/ThisDirectory");

            if(makedir.exists()) {
                System.out.println("Directory already exist");
            } else {
                 makedir.mkdir();
                System.out.println("Directory created");
            }

            // Under that directory crate a new file gitShow.txt

            if(makedir.exists()){
                try {
                    File file = new File("Java/FileHandling/ThisDirectory/gitShow.txt");
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println(e.getStackTrace());
                }
            }
            else {
                System.out.println("File cretion failed");
            }

    }
}
