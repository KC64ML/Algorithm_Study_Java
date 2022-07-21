package plzrun.dp;

import java.util.*;

public class dp11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());


        int[] dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 3;
            } else {
                dp[i] = (dp[i - 2] * 2 % 10007 + dp[i - 1] % 10007) % 10007;
            }

        }

        System.out.println(dp[n] % 10007);

        sc.close();
    }
}
