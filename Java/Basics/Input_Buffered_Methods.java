import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input_Buffered_Methods {
    public static void main(String[] args) throws IOException {

        // To sending and receiving the data we need a "stream" 
        //This stream is flow of data from one place to another place.
        // 2 types
        // 1> input stream   2> output stream
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        //Their are 2 predefined methods
        // read()     :=> character read but it return ASCII value so wwe must typecasting
        // readLine() :=> This method is used to receive a string from the keyboard.

        System.out.print("Enter a character : ");
        char ch = (char)br.read();
        System.out.println(ch);
        br.readLine(); //consumes remaining part from the buffer(Consume the leftover newline)

        //for primitive data type values we must parsing ro specific type that is called Wrapper class.
        System.out.print("Enter integer value : ");
        int num = Integer.parseInt(br.readLine());
        System.out.println(num);
    }
}
