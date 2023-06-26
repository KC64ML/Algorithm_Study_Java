package programmers.Lv1.모의고사;

import java.util.*;

public class Solution {

    private static final int[] mathDrop1 = {1,2,3,4,5};
    private static final int[] mathDrop2 = {2,1,2,3,2,4,2,5};
    private static final int[] mathDrop3 = {3,3,1,1,2,2,4,4,5,5};

    public ArrayList<Integer> solution(int[] answers) {

        int[] correctCount = new int[3];

        for(int gameProblem = 0; gameProblem < answers.length; gameProblem++){
            if(answers[gameProblem] == mathDrop1[gameProblem % mathDrop1.length]) correctCount[0] += 1;
            if(answers[gameProblem] == mathDrop2[gameProblem % mathDrop2.length]) correctCount[1] += 1;
            if(answers[gameProblem] == mathDrop3[gameProblem % mathDrop3.length]) correctCount[2] += 1;
        }

        int maxData = Math.max(correctCount[0], correctCount[1]);
        maxData = Math.max(maxData, correctCount[2]);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(correctCount[i] == maxData) answer.add(i + 1);
        }

        return answer;
    }
}