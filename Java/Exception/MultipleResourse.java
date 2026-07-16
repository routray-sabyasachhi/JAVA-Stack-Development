package Java.Exception;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultipleResourse {
    public static void main(String[] args) {
        try ( 
            BufferedReader reader = new BufferedReader(new FileReader("Java/Exception/input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("Java/Exception/output.txt"));
        ) {
            String line;
            while((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("file wrote successfully...");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
