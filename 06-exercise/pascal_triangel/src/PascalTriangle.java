public class PascalTriangle {
    public static void main(String[] args) {
//        1
//        1 1
//        1 2 1
//        1 3 3 1
//        1 4 6 4 1
        int [][] arr=new int [10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;j <= i;j++){
                if (j==0||j==i) arr[i][j] = 1;
                else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0;j <= i;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
