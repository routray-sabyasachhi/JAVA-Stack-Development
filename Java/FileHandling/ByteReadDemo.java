package Java.FileHandling;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteReadDemo {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("Java/FileHandling/ThisDirectory/input.txt")) {
            int data;
            while((data = input.read()) != -1) {
                System.out.print((char)data);
            }
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
