package programmers.LV3.하노이의_탑;

import java.util.*;

public class Solution {

    private void hanoi(int n, int from, int to, List<int[]> process){
        // 만약 n이 1일 때 결과를 전달함
        if(n == 1){
            process.add(new int[]{from, to});
            return;
        }

        // n - 1 from -> empty
        // 1(제일 마지막 데이터) from -> to
        // n - 1 empty -> to
        int empty = 6 - from - to;
        hanoi(n - 1, from, empty, process);
        hanoi(1, from, to, process);
        hanoi(n - 1, empty, to, process);
    }

    public List<int[]> solution(int n) {
        int[][] answer = {};

        List<int[]> process = new ArrayList<>();
        // 원판 n, from, to, process (empty : 현재 비어있는 곳)
        hanoi(n, 1, 3, process);

        return process;
    }
}
