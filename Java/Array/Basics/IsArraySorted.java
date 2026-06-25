package Java.Array.Basics;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr1 = {1,5,8,85,47,69,-35,-5,-18};
        int[] arr2 = {1,2,5,15,25};

        checkArraySort(arr1, arr1.length);
        checkArraySort(arr2, arr2.length);
    }

    private static void checkArraySort(int[] arr, int n){
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 0; i < (n-1); i++) {
            if(arr[i] > arr[i+1])
                increasing = false;
            if(arr[i] < arr[i+1])
                decreasing = false;
        }

        if(increasing || decreasing) 
            System.out.println("Array is Sorted.");
        else
            System.out.println("Array is not sorted");
    }
}
