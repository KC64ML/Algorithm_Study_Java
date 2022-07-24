package Baekjoon;

import java.util.*;

public class BJ2443 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = n;i>0;i--) {
            for(int j = n - i; j > 0; j--) {
                System.out.printf("%s", " ");
            }
            for(int j = i * 2 - 1; j > 0 ; j--) {
                System.out.printf("%s","*");
            }
            System.out.println();
        }
    }

}