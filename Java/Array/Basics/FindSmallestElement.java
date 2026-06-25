package Java.Array.Basics;

public class FindSmallestElement {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        int small = arraySmallElement(arr, arr.length);
        System.out.println("Array's smallest Element : " + small);
    }

    private static int arraySmallElement(int[] arr, int n) {

        int small = arr[0]; // here consider array element as largest

        for(int i = 1; i<n; i++) {
            if(arr[i] < small)
             small = arr[i];
        }
        return small;
    }
}
