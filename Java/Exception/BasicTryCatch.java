package Java.Exception;

public class BasicTryCatch {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b ;
            System.out.println(result);

            System.out.println("is return again to try block...");
        } catch (ArithmeticException e){
            System.out.println("Exception caught...");
        } catch (OutOfMemoryError e2){  // multiple catch block can be written
            System.out.println(e2.getMessage());
        } finally {  
            // (optional) but if  it written program may or may not throws exception but finally block will be executed.
            // use it for clean up codes
            System.out.println("Finally block always executes...");
        }

        System.out.println("program continued...");
    }
}


// only one catch block executes (the first match)

// Catch more specific exceptions first
// then catch general exception last