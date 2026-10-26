public class VarargsDemo {
    static int sums(int...nums){
        System.out.print("长度:"+nums.length+" ");
        int total = 0;
        for(int i = 0; i < nums.length; i++)
            total += nums[i];
        return total;
    }

    static void printSum(int label,int...nums){
        System.out.println("sum="+sums());
    }

//    static void printSums(int...nums,int label){}

    public static void main(String[] args) {
        System.out.println("sum="+sums());
        System.out.println("sum="+sums(5));
        System.out.println("sum="+sums(1, 2, 3, 4, 5));
        System.out.println("sum="+sums(new int []{10,20,30}));
    }
}
