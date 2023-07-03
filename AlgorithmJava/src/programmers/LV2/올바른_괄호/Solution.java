package programmers.LV2.올바른_괄호;

import java.util.Stack;

public class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            switch(c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                {
                    if(stack.isEmpty()) return false;
                    stack.pop();
                    break;
                }
            }
        }

        return stack.isEmpty();
    }
}