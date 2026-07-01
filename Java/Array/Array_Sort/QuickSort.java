package Java.Array.Array_Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        System.out.println("Before sorting: ");
        for(int num : arr)
            System.out.print(num + " ");

        // Sorting function call

        quickSort(arr);



        System.out.println();

        System.out.println("After Sorting :");
        for(int num : arr)
            System.out.print(num + " ");
    }

    public static void quickSort(int[] arr) {

    }
}
