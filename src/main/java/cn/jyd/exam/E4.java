package cn.jyd.exam;

public class E4 {
    public static void main(String[] args) {
        f(1,2);
        f(-1,-2,-3,-4);
    }
    public static void f(int... x){
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]+"\t");
        }
        System.out.println();
    }
}
