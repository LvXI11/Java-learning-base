import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        二分查的前提找必须是有序数组
        int [] arr = new int[]{1,2,3,4,5,6,8,9};
        System.out.print("请输入要查找的数：");
        int target = sc.nextInt();
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target == arr[mid]){
                result = mid;
                break;
            }
            else if(target > arr[mid]) left = mid+1;
            else right = mid-1;
        }
        if(result != -1) System.out.printf("找到了%d，index为%d%n",target,result);
        else System.out.printf("未找到%d%n",target);
    }
}
