import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.lang.Integer;   // older version

public class Buffered_Input {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fullName = br.readLine();
        System.out.println(fullName);
        int n = Integer.parseInt(br.readLine());   
        // The parseInt() method of class Integer converts the string to type int. 
        // A similar routine, parseLong(), can be used to convert type long.
        // Integer the "wrapper" class of type integer
        System.out.println(n);
        
    }
}
