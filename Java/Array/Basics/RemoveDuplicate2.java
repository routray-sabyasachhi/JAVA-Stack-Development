package Java.Array.Basics;


import java.util.Arrays;

public class RemoveDuplicate2 {
    public static void main(String[] args) {

        int[] arr = {1,5,-18,8,85,47,5,69,-35,85,-5,-18};

        Arrays.sort(arr);

        int j = 0;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }

        System.out.println(
            Arrays.toString(Arrays.copyOf(arr, j + 1))
        );
    }
}
