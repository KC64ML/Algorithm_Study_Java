package programmers.LV2.주식가격;

import java.util.*;

public class Solution2 {

    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];
        for(int i = 0 ; i < prices.length - 1; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int beforeIndex = stack.pop();
                answer[beforeIndex] = i - beforeIndex;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int beforeIndex = stack.pop();
            answer[beforeIndex] = prices.length - beforeIndex - 1;
        }

        answer[prices.length - 1] = 0;

        return answer;
    }
}
