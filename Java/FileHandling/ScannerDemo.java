package Java.FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        
        //Scanner is used to read input from files, keyboard, or other sources

        try (Scanner scanner = new Scanner(new File("Java/FileHandling/ThisDirectory/input.txt"))){
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter("Java/FileHandling/ThisDirectory/report.txt")) {
            writer.println("Name : Sabya");
            writer.printf("Age : %d\n", 22);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
    }
}
