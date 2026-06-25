package Java.Array.Basics;

public class FindLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        int large = arrayLargeElement(arr, arr.length);
        System.out.println("Array's large Element : " + large);
    }

    private static int arrayLargeElement(int[] arr, int n) {

        int large = arr[0]; // here consider array element as largest

        for(int i = 1; i<n; i++) {
            if(arr[i] > large)
                large = arr[i];
        }
        return large;
    }
}
