package Java.Array.Basics;

public class LeftRotateByOne {
    public static void main(String[] args) {
        int[] arr = {1,5,8,85,47,69,-35,-5,-18};

        System.out.println("Before left rotate : ");
        for(int data : arr) {
            System.out.print(data + " ");
        }

        leftRotate(arr);
        

        System.out.println();
        System.out.println("After left rotate");

        for(int data : arr) {
            System.out.print(data + " ");
        }
    }

    public  static void leftRotate(int[] arr) {
        int temp_hold = arr[0];
        int n = arr.length;

        // loop for left shift

        for(int i=0; i<(n-1); i++){
            arr[i] = arr[i+1];
        }

        // put first value(temp_hold) to last index
        arr[n-1] = temp_hold;
    }
}
