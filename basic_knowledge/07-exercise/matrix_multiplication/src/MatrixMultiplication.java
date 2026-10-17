public class MatrixMultiplication {
    public static void main(String[] args) {
        int [][] matrix1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int [][] matrix2 = new int[][]{{9,8,7},{6,5,4},{3,2,1}};
        int [][] matrix3 = new int [3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++){
                for (int k = 0; k < matrix1[i].length; k++){
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++){
                System.out.print(matrix1[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++){
                System.out.print(matrix2[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < matrix3.length; i++) {
            for (int j = 0; j < matrix3[i].length; j++){
                System.out.print(matrix3[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
