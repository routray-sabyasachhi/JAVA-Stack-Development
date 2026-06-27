//package Java.Array.Array_Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        System.out.println("Before sorting: ");
        for(int num : arr)
            System.out.print(num + " ");

        // Sorting function call

        bubbleSort(arr);



        System.out.println();

        System.out.println("After Sorting :");
        for(int num : arr)
            System.out.print(num + " ");
    }

    public static void bubbleSort(int[] arr) {
    int size = arr.length;

    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {

            if (arr[j] > arr[j + 1]) {

                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
}
