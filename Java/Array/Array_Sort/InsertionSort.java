package Java.Array.Array_Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        System.out.println("Brfore sorting :");

        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();

        insertionSort(arr);

        System.out.println("After sorting : ");
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr) {
        int size = arr.length;
        for(int i=1; i<size; i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && (arr[j]>key)){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
}
