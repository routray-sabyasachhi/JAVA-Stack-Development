package Java.Array.Basics;

public class CountEvenOddInArray {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        findEvenOdd(arr, arr.length);
    }

    private static void findEvenOdd(int[] arr, int n){
        int even = 0, odd = 0;
        for(int i=0; i<n; i++) {
            if(arr[i]%2 == 0)  // Here check even or odd
                even++;  // if even
            else 
                odd++;   // if odd
        }
        System.out.println("No of Even & Odd are " + even + " & " + odd + " respectively.");
    }
}
