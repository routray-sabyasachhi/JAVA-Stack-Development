package Java.FileHandling;

import java.io.File;
import java.io.IOException;

public class RenameFileProcess {
    public static void main(String[] args) {
        File oldFile = new File("Java/FileHandling/ThisDirectory/oldFile.txt");

        try {
            if(oldFile.exists())
                System.out.println("Already exists...");
            else {
                oldFile.createNewFile();
                System.out.println("file created");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

// below file renamed
        if(oldFile.exists()) {
            File renameFile = new File("Java/FileHandling/ThisDirectory/Renamed.txt");
            oldFile.renameTo(renameFile);
            System.out.println("File renamed successfully...");
        }

    }
}
