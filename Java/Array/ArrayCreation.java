// package Java.Array;

import java.util.Scanner;

public class ArrayCreation {
    public static void main(String[] args) {
        // int arr[] = {2, 3 , 5 ,56 ,9};   in C / C++

        int[] arr1 = {2,5,9,11,85};   // syntax of creating and initializing of an array
        System.out.println(arr1[0] + " " + arr1[1]);

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr2 = new int[size];  // size must be defined

        // we can take input for array elements separately or in loop method(preferred)
        for(int i=0; i<size; i++){
            System.out.println(arr2[i] + " ");
        }
    }
}
