package Baekjoon.implementation;

import java.util.*;
import java.io.*;

public class BJ2490 {
    public static void main(String[] args) throws IOException {
        // 배 0 등 1
        // 도 : 0 1  1 1
        // 개 : 0 0  1 1
        // 걸 : 0 0 0 1
        // 윷 : 0 0 0 0
        // 모 : 1 1 1 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i< 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];

            for(int j = 0; j < arr.length;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long num = Arrays.stream(arr).filter(z -> z == 0).count();

            if(num == 1)
                System.out.println("A");
            else if(num == 2)
                System.out.println("B");
            else if(num == 3)
                System.out.println("C");
            else if(num == 4)
                System.out.println("D");
            else
                System.out.println("E");
        }




    }
}
