package programmers.LV3.단속카메라;

import java.util.Arrays;

public class Solution2 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> {
            if(r1[1] > r2[1]) return 1;
            else if(r1[1] < r2[1]) return -1;
            else return 0;
        });


        int curCamera = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i < routes.length; i++){
            if(curCamera < routes[i][0]){
                curCamera = routes[i][1];
                answer += 1;
            }
        }

        return answer;
    }
}
