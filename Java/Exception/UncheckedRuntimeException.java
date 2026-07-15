package Java.Exception;

public class UncheckedRuntimeException {
    public static void main(String[] args) {

        // nullPointerException - unchecked
        String str = null;
        System.out.println(str.length());

        // ArithmeticException - unchecked
        int result = 10 / 0;
        System.out.println(result);

        // ArrayIndexOutOfBound - unchecked
        int[] arr = {1, 5, 15, 45, 89};
        System.out.println(arr[7] + " and " + arr[-1]);
    }
}
