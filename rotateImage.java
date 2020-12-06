class tempCodeRunnerFile {
    public static void main(String args[]) {
        int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        printmatrix(matrix);
        transpose(matrix);
        printmatrix(matrix);
        reverse(matrix);
        printmatrix(matrix);
        System.out.println("world".substring(5, 2));
    }
    public static void printmatrix(int[][] matrix) {
        System.out.println("printing the matrix");
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
    }
    public static void reverse(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-j-1];
                matrix[i][matrix.length-j-1] = temp; 
            }
        }
    }
}