package plzrun.dp;

import java.util.*;

public class bj11726 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] dp = new int[n+1];


        if(n == 1){
            System.out.println(1);
        }else if(n == 2){
            System.out.println(2);
        }else{
            dp[1] = 1;
            dp[2] = 2;

            for(int i=3; i<=n;i++){
                dp[i] = (dp[i -1] % 10007 + dp[i-2] % 10007) % 10007;
            }

            System.out.println(dp[n]);
        }


        sc.close();
    }
}
