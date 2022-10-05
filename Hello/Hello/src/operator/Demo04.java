package operator;

public class Demo04 {
    public static void main(String[] args) {
        // ++ -- 自增 自减 一元运算符
        int a = 3;

        int b = a++; // 执行完这行代码之后 先赋值再自增
        int c = ++a; // 执行完这行代码前 先自增再赋值

        System.out.println(a); // 5 5 3 3 5 5
        System.out.println(a);
        System.out.println(b);
        System.out.println(b);
        System.out.println(c);
        System.out.println(c);

        // 幂运算 2^3 工具class such as pow
        double pow = Math.pow(3,3);
        System.out.println(pow);
    }
}
