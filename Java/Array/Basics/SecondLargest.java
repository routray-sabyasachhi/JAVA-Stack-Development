package Java.Array.Basics;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        int secondLargest = arraySecondLargeElement(arr, arr.length);
        System.out.println("Array's second largest Element : " + secondLargest);
    }

    private static int arraySecondLargeElement(int[] arr, int n) {

        int large = arr[0]; // here consider array element as largest
        int secondLarge = arr[0];

        for(int i = 1; i<n; i++) {
            if(arr[i] > large){
                secondLarge = large;
                large = arr[i];
            }
             else if (arr[i] > secondLarge && arr[i] != large) {
            secondLarge = arr[i];
        }
        }
        return secondLarge;
    }
}
