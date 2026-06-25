package Java.Array.Array_Search;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};
        System.out.print(" Enter the searching key : ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();
        sc.close();

        linearArraySearch(arr, arr.length, key);
    }

    public static void linearArraySearch(int[] arr, int n, int key){
        boolean found = false;
        for(int i=0; i<n; i++) {
            if(key == arr[i]){
                found = true;
                System.out.println("Entered value " + key + " found in the " + (i+1) + " position.");
                break;
            }
        }
        if(!found)
            System.out.println("Entered value " + key + " not found...");
    }
}
