package Java.Exception;

import java.io.FileReader;
import java.io.IOException;

public class CommonUseOfFinally {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            if(reader != null) {
                try {
                    reader.close(); // always close the resourse
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
