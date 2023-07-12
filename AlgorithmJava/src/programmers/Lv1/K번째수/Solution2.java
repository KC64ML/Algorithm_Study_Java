package programmers.Lv1.K번째수;

import java.util.*;

public class Solution2 {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for(int[] command : commands){
            int start = command[0] - 1;
            int end = command[1];
            int k = command[2] - 1;


            int[] copyArray = Arrays.copyOfRange(array, start, end);

            // 정렬
            Arrays.sort(copyArray);


            // k번째 숫자
            answer.add(copyArray[k]);
        }

        return answer;
    }
}
