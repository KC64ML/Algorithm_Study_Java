package programmers.LV2.올바른_괄호;

import java.util.Stack;

public class Solution2 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == ')' && stack.isEmpty()) return false;
            else if(c == '(') stack.push('(');
            else if(c == ')') stack.pop();
        }

        return stack.isEmpty();
    }
}
