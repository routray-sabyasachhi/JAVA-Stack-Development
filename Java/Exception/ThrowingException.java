package Java.Exception;


public class ThrowingException {
    public static void main(String[] args) {
        try {
            checkAge(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void  checkAge(int n) {
        if(n < 0)
            throw new IllegalArgumentException(n + " is a invalid age...");

        // Above is the syntax of throw Exception
    }
}
