package Baekjoon;

public class test {
    private static int swap3(int localA, int localB) {
        return localA;
    }

    public static void main(String[] args) {
        int a = 20, b= 5;
        b = swap3(a, a= b);
        System.out.println(a + " " + b);
    }

}