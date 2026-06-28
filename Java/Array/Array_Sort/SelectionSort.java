package Java.Array.Array_Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

         System.out.println("Before sorting: ");
        for(int num : arr)
            System.out.print(num + " ");

        // Sorting function call

        selectionSort(arr);



        System.out.println();

        System.out.println("After Sorting :");
        for(int num : arr)
            System.out.print(num + " ");
    }

    public static void selectionSort(int[] arr){
        int minIndex = -1;
        int size = arr.length;
        int temp = 0;

        for(int i=0; i<size-1; i++){
            minIndex = i;
            for(int j=i+1; j<size; j++) {
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
