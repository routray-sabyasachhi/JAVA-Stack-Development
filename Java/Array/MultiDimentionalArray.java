package Java.Array;

public class MultiDimentionalArray {
    public static void main(String[] args) {
        int m=3, n=5;
        int[][] multiArray = new int[m][n]; 

        //Initializing of array
        for(int i=0; i<multiArray.length; i++) {
            for(int j=0; j< multiArray[i].length; j++){
                multiArray[i][j] = i+j;
            }
        }

        multiArrayPrinting(multiArray,m,n);
    }

    public static void multiArrayPrinting(int[][] x, int m, int n){
        for(int i=0; i<m; i++) {
            for(int j=0; j< n; j++){
                System.out.print(x[i][j]+" ");
            }
            System.out.println();
        }
    }
}
