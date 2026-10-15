import java.io.Serial;

public class ThrowsDemo {
    static void setAge(int age) throws AgeException{
        if (age < 0 || age > 150) {
            throw new AgeException("年龄越界");
        }
        System.out.println("年龄已设置：" + age);
    }

    public static void main(String[] args) {
//        setAge(-1);Exception in thread "main" java.lang.IllegalArgumentException: 年龄不合法：-1
        setAge(2);

        try {
            setAge(-1);
        } catch (AgeException e) {
            System.out.println(e.getMessage() + "1111111");
            e.printStackTrace();
        }

        try {
            methodB();
        }catch (UnCheckedEx e){
            System.out.println(e.getMessage());
        }

        try {
            methodA();
        }catch (CheckedEx e){
            System.out.println("methodA()");
            e.printStackTrace();
        }
    }

    static void methodA() throws CheckedEx {
        throw new CheckedEx();
    }

    static void methodB() throws UnCheckedEx {
        throw new UnCheckedEx();
    }
}

class CheckedEx extends Exception{
    @Serial
    private static final long serialVersionUID = 1212222L;
}


class UnCheckedEx extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 12222L;
}

class AgeException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 121992222L;
    public AgeException(String message){
        super(message);
    }
}