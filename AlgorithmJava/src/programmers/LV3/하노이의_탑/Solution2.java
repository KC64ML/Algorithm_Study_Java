package programmers.LV3.하노이의_탑;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {

    private void hanoi(int from, int to, int n, List<int[]> answer){
        // 도착했을 때
        if(n == 1){
            answer.add(new int[]{from, to});
            return;
        }

        int other = 6 - from - to;
        hanoi(from, other, n - 1, answer);
        hanoi(from, to, 1, answer);
        hanoi(other, to, n - 1, answer);
    }

    public List<int[]> solution(int n) {

        // from + to + other = 6
        List<int[]> answer = new ArrayList<>();
        hanoi(1, 3, n, answer);
        return answer;
    }
}
