package Java.Exception;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ThrowsKeyword {

    public static void readFile() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        String token;
        while((token = reader.readLine()) != null){
            System.out.println(token);
        }
        reader.close();
    }
    public static void main(String[] args) {
        try {
            readFile();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
