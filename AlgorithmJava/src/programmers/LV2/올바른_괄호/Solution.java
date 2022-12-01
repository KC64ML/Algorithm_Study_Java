package programmers.LV2.올바른_괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();


        for (char inS : s.toCharArray()) {
            char curS = ' ';

            if (inS == '(') {
                stack.push(inS);
            } else if (inS == ')' && stack.size() > 0) {
                curS = stack.pop();
                if (curS == '(') continue;
                else {
                    answer = false;
                    break;
                }
            } else {
                answer = false;
                break;
            }
        }

        if (stack.size() > 0) answer = false;

        return answer;
    }
}