package plzrun.dp;

import java.util.*;

public class bj1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] dp = new int[n+1];

        dp[1] = 0;

        for(int i = 2; i <= n;i++){

            // 1을 빼준다.
            dp[i] = dp[i -1] +1;

            // 2로 나누어 떨어지면, 2로 나누어준다.

            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i] , dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);

        sc.close();
    }
}
