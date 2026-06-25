package Java.Array;

public class AverageOfArray {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18}; // array creation

        int sum = sumArray(arr, arr.length); // Array sum function call

        double avg = (double)sum / arr.length; // Average calculation

        System.out.println("Average : " + avg);   //o/p
    }

    public static int sumArray(int[] arr, int n) {  // array sum calculation
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        return sum;
    }
}
