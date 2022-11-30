package programmers.LV2.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 0;

        int[] dp = new int[n+1];

        for(int i = 1; i<= n; i++){
            dp[i] = dp[i - 1] + i;
        }

        if(n % 2 != 0) start = (n / 2) + 1;
        else start = (n / 2);

        answer = 1;

        for(int i = start; i > 1 && dp[i] >= n ; i--){
            for(int j = i; dp[i] - dp[j] <= n; j--){
                if(n == dp[i] - dp[j]){
                    // System.out.println("i, j : " + " " + i + " " + j);
                    answer += 1;
                    break;
                }
            }
        }
        return answer;
    }
}