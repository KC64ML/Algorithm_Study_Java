package programmers.LV2.큰수만들기;

import java.util.Stack;
import java.util.stream.Collectors;

public class Solution3 {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();

        int[] arr = number.chars().map((c) -> c - '0').toArray();

        for(int index = 0; index < arr.length; index++){
            while(k > 0 && !stack.isEmpty() && stack.peek() < arr[index]){
                stack.pop();
                k--;
            }
            stack.push(arr[index]);
        }


        while(stack.size() > arr.length - k) stack.pop();

        return stack.stream().map(String::valueOf).collect(Collectors.joining());

    }
}
