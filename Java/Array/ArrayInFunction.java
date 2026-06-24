package Java.Array;

import java.util.Scanner;

public class ArrayInFunction {
    public static void main(String[] args) {

        System.out.print("Enter the size of an array: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();
        double[] arr = new double[size];
        int length = arr.length;

        arrayPrintElement(arr,length);
    }

    public static void arrayPrintElement(double[] x, int length) {   // Here x is the shallow copy of arr array.
       //  Shallow means call by reference
        // Taking input for the array elements
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<length; i++){
            System.out.print("Enter the value of " + (i+1)+ "element :");
            x[i] = sc.nextDouble();
        }
        sc.close();

        // print the array Element values  default value is double(0.0), int(0) etc.
        for(int i=0;i < length; i++) {
            System.out.print(x[i] + " ");
        }
        
    }
}
