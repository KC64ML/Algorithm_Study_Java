package programmers.LV2.괄호_회전하기;

import java.util.Stack;

public class Solution2 {

    private boolean isCorrect(char[] c, int offset){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < c.length; i++){
            char parenthesis = c[(i + offset) % c.length];

            switch(parenthesis){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')': case ']': case '}':
                    if(stack.isEmpty()) return false;
                    if(parenthesis != stack.pop()) return false;
                    break;
            }


        }
        // System.out.println(stack.size());
        return stack.isEmpty();
    }

    public int solution(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        for(int offset = 0; offset < s.length(); offset++){
            if(isCorrect(c, offset)){
                count++;
            }
        }
        return count;
    }
}
