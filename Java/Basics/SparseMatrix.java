class SparseMatrix {
    public static void main(String[] args) {
        int[][] nums = {  {7,0,0,1,0,2},
                          {0,1,9,0,0,0},
                          {0,0,0,7,0,0},
                          {0,0,0,0,0,0},
                          {8,0,0,0,0,0},
                          {0,0,3,0,0,0}   };
        
        int k = 1, counter = 0;

        // count number of non-zero elements
        for(int i=0; i< nums.length; i++) {
            for(int j=0; j< nums[0].length; j++){
                if(nums[i][j] != 0){
                    counter++;
                }
            }
        }

        // Declare the triplet form of sparse matrix
        int[][] sparseMatrix = new int[counter+1][3];  // +1 for extra row which store [total number of row, total number of column, total number of non-zero elements]


        // Now initialize sparse triplet first row
        sparseMatrix[0][0] = nums.length;
        sparseMatrix[0][1] = nums[0].length;
        sparseMatrix[0][2] = counter;

        // initialize in triplet sparse matrix
        for(int i=0; i< nums.length; i++) {
            for(int j=0; j< nums[0].length; j++){
                if(nums[i][j] != 0){
                    sparseMatrix[k][0] = i;
                    sparseMatrix[k][1] = j;
                    sparseMatrix[k][2] = nums[i][j];

                    k++;
                }
            }
        }

        // Display sparsematrix in triplet form
        for(int i=0; i<counter+1; i++){
            for(int j=0; j<3; j++) {
                System.out.print(sparseMatrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
