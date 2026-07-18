package Java.FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyByByteStream {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("Java/FileHandling/ThisDirectory/output.txt");
    FileOutputStream out = new FileOutputStream("Java/FileHandling/ThisDirectory/copyStream.txt")) {
            int data;
            
            // copy the data byte by byte
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
