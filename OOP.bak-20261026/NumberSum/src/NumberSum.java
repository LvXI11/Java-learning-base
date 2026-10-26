public class NumberSum {

    public static boolean isDigits(String string){
        if(string == null || string.length() == 0) return false;
        for (int i = 0; i < string.length(); i++) {
            if(!Character.isDigit(string.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static int process(String data){
        String[] parts = data.split(",");
        int count = 0;
        for(String s : parts){
            if(isDigits(s)){
                Integer num = Integer.valueOf(s);
                count += num;
            }else{
                System.out.println("跳过片段：" + s);
            }
        }
        return count;
    }

    public static void main(String[] args) {

        String data = "12,ab,7,x9,30,9x";
        String data2 = "12,,30,x8,2,3x";
        System.out.println("和 = " + process(data));
        System.out.println();
        System.out.println("和 = " + process(data2));

    }
}
