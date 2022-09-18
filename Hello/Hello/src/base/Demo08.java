package base;

public class Demo08 {
    // int a,b,c;
    // int a = 1, b= 2,c=3; // 程序可读性很差 写成三行较好
    String name = "castle";
    static double salary = 2500;

    public static void main(String[] args) {
        Demo08 demo08 = new Demo08();
        System.out.println(demo08.name);
        System.out.println(salary);
    }
}
