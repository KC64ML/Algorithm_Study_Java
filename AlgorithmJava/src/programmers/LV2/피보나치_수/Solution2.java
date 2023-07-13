package programmers.LV2.피보나치_수;

public class Solution2 {

    // 재귀로 구현 할려고 했는데 시간 초과
    // (1) 상태 : (n)
    // (2) 종료조건 : n == 1
    // (3) 점화식 : F(n) = F(n - 1) + F(n - 2)

    private int fibonacci(int n){
        if (n == 1) return 1;
        else if(n == 0) return 0;

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        return result;
    }

    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
