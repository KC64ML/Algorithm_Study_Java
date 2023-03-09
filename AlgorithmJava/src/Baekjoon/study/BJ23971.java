package Baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int H = Integer.parseInt(s[0]);
        int W = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);
        int M = Integer.parseInt(s[3]);

        int answer = 0;

        for(int i =1 ;i<= H; i += (N + 1)){
            for(int j =1; j<= W; j+= (M + 1) ){
                answer += 1;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
