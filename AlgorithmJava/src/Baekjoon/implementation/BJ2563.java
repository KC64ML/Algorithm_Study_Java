package Baekjoon.implementation;

import java.util.*;

public class BJ2563 {

    static int[][] arr = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int cnt = 0;
        while(n > 0){
            int a = sc.nextInt();
            int b = sc.nextInt();

            for(int i = a; i < a+10;i++){
                for(int j = b ; j < b+10;j++){
                    if(arr[i][j] == 0){
                        arr[i][j] = 1;
                        cnt += 1;
                    }
                }
            }
            n -= 1;
        }
        System.out.println(cnt);
    }
}
