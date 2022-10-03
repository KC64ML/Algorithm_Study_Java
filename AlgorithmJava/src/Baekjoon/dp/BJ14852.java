package Baekjoon.dp;

import java.io.*;

public class BJ14852 {

    static long[] dp;
    static int N;
    static long maxNum = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        dp[0] = 1;
        dp[1] = 2;

        if (N >= 2) {
            dp[2] = 7;
            long tmp = 0; // i-2, i-1번째 제외 나머지로 만들 수 있는 타일
            for (int i = 3; i <= N; i++) {
                dp[i] = (dp[i - 2] * 3 % maxNum + (dp[i - 1] * 2) % maxNum + 2 * (tmp += dp[i - 3])) % maxNum;
            }
            System.out.println(dp[N]);
        } else {
            System.out.println(dp[1]);
        }


        
    }
}
