package programmers.Lv1.모의고사;

import java.util.*;

public class Solution3 {

    private int[] people1 = {1, 2, 3, 4, 5};
    private int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    private int[] count = new int[3];

    public List<Integer> solution(int[] answers) {

        for(int i = 0; i < answers.length; i++){
            if(answers[i] == people1[i % people1.length]) count[0]++;
            if(answers[i] == people2[i % people2.length]) count[1]++;
            if(answers[i] == people3[i % people3.length]) count[2]++;
        }


        List<Integer> answer = new ArrayList<>();

        int maxValue = 0;
        maxValue = Math.max(count[0], count[1]);
        maxValue = Math.max(maxValue, count[2]);

        for(int i = 0; i < 3; i++){
            if(maxValue == count[i]) answer.add(i + 1);
        }

        return answer;
    }
}
