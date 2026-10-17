import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入阶数：");
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        int num = 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) arr[top][i] = num++;
                top++;
            for (int j = top; j <= bottom; j++) arr[j][right] = num++;
                right--;
            for (int i = right; i >=left ; i--) arr[bottom][i] = num++;
                bottom--;
            for (int j = bottom; j >= top; j--) arr[j][left] = num++;
            left++;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++){
                System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }
    }
}
