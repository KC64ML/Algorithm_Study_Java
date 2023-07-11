package programmers.Lv1.모의고사;

import java.util.*;

public class Solution2 {

    // 1, 2, 3번 수포자가 찍는 방식
    private static int[] arr1 = {1,2,3,4,5};
    private static int[] arr2 = {2,1,2,3,2,4,2,5};
    private static int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

    public List<Integer> solution(int[] answers) {
        int[] mathGiveUp = new int[3];


        for(int game = 0; game < answers.length; game++){
            if(answers[game] == arr1[game % arr1.length]) mathGiveUp[0] += 1;
            if(answers[game] == arr2[game % arr2.length]) mathGiveUp[1] += 1;
            if(answers[game] == arr3[game % arr3.length]) mathGiveUp[2] += 1;

        }

        int maxData = Math.max(mathGiveUp[0],mathGiveUp[1]);
        maxData = Math.max(maxData, mathGiveUp[2]);

        List<Integer> answer = new ArrayList<>();
        for(int i = 0 ;i < 3; i++){
            if(maxData == mathGiveUp[i]) answer.add(i + 1);
        }
        return answer;
    }
}
