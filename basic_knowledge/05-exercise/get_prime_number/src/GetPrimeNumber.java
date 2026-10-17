public class GetPrimeNumber {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        boolean isFlag = true;
        int count = 0;
        for(int i=2;i<=100000;i++){
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag) count++;
            isFlag = true;
        }
        long end=System.currentTimeMillis();
        System.out.println("100000以内的质数有"+count+"个");
        System.out.println("搜索花费时间"+(end-start)+"ms");
    }/*：因子总是成对出现的
比如判断 36 是不是质数，它的因子成对：
1 × 36
2 × 18
3 × 12
4 × 9
6 × 6 ← 这对因子相等，就是分界点
规律：
每对因子里，小的 ≤ √i，大的 ≥ √i
只要找到一个小因子，就知道它不是质数
所以只用查小因子那一半，也就是查到 √i 为止
*/
}
