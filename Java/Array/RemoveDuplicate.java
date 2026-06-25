package Java.Array;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,5,-18,8,85,47,5,69,-35,85,-5,-18};

        int newSize = remove_duplicate_from_Array(arr, arr.length);
        System.out.println("Array after removing duplicates: " + Arrays.toString(Arrays.copyOf(arr, newSize)));
    }

    private static int remove_duplicate_from_Array(int[] arr, int n) {
        for(int i=0; i<(n-1); i++) {
            for(int j = (i+1); j< n;j++) {
                if(arr[i] == arr[j]) {
                    for(int k = j; k < (n-1); k++) {
                        arr[k] = arr[k+1];
                    }
                    n--;
                    j--;
                }
            }
        }
        return n;
    }
}
