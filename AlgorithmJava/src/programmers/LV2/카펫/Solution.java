package programmers.LV2.카펫;

import java.util.*;

public class Solution {
    private int horizontal, vertical;
    public ArrayList<Integer> solution(int brown, int yellow) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 가로 = brown x 1/2 + 2 - 세로
        // 세로 => (1/2 x brown - 세로) x (세로 - 2) = yellow
        for(int height = 2; height < 4000; height++){
            double col = (brown * (0.5) - height) * (height - 2);
            if(col == yellow){
                answer.add((int)(brown * (0.5)) + 2 - height);
                answer.add(height);
                break;
            }
        }

        return answer;
    }
}