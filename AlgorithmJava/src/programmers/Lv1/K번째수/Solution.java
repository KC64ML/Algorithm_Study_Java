package programmers.Lv1.K번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;

        for(int[] command : commands){
            // command 0, 1, 2

            int from = command[0] - 1;
            int to = command[1];
            int index = command[2] - 1;
            // System.out.println("from : " + from + " to : " + to + " index : " + index);
            int[] copyArray = Arrays.copyOfRange(array, from, to);
            Arrays.sort(copyArray);
            answer[answerIdx++] = copyArray[index];

        }

        return answer;
    }
}