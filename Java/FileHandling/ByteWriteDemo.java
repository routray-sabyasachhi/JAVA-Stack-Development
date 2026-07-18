package Java.FileHandling;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWriteDemo {
    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("Java/FileHandling/ThisDirectory/output.txt")){
            output.write("Welcome to java world...".getBytes());
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}
