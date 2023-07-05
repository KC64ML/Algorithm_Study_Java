package programmers.LV2.타겟넘버;

import java.util.Stack;

public class Solution {
    private static class State {
        public final int index; // 현재 numbers 인덱스
        public final int acc; // 덧셈한 결과

        State(int index, int acc){
            this.index = index;
            this.acc = acc;
        }
    }
    public int solution(int[] numbers, int target) {
        Stack<State> stack = new Stack<>();
        stack.push(new State(0, 0));

        int count = 0;

        while(!stack.isEmpty()){
            State state = stack.pop();

            if(state.index == numbers.length){
                if(state.acc == target) count++;

                continue;
            }

            // 만약 +를 선택했을 때
            stack.push(new State(state.index + 1, state.acc - numbers[state.index]));
            stack.push(new State(state.index + 1, state.acc + numbers[state.index]));
        }

        return count;
    }
}