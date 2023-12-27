import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String s = Arrays.stream(numbers).mapToObj(String::valueOf)
            .sorted((num1, num2) -> {
                int original = Integer.parseInt(num1 + num2);
                int second = Integer.parseInt(num2 + num1);
                
                return second - original;
            }).collect(Collectors.joining(""));
        // replace()
        
        if(s.charAt(0) == '0') return "0";
        // System.out.println(s);
        return s;
    }
}