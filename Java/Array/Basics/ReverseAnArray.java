package Java.Array.Basics;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};  // Initial array

        System.out.println("Before array reverse :");
        for(int data : arr){
            System.out.print(data + " ");
        }

        reverseArray(arr);

        System.out.println("\n After array reverse :");
        for(int data : arr){
            System.out.print(data + " ");
        }
    }

    public static void reverseArray(int[] arr) {
        // solve this by two pointer method

        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}
