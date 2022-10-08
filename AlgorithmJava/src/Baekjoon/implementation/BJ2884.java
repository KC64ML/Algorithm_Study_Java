package Baekjoon.implementation;

import java.util.*;

public class BJ2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());


        if(b < 45){
            a -= 1;
            b = 15 + b;
        }else{
            b -= 45;
        }

        if(a < 0){
            a = 23;
        }

        System.out.println(a + " " + b);
    }
}
