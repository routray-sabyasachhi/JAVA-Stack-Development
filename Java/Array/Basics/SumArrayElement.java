package Java.Array.Basics;

public class SumArrayElement {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        int sum = sumArray(arr, arr.length);
        System.out.println("Sum of Array Elements : " + sum);
    }

    public static int sumArray(int[] arr, int n) {
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        return sum;
    }
}
