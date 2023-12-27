import java.util.*;

class Solution {
    // Arrays.strea().mapToInt().
    public String solution(int[] numbers) {
        numbers = Arrays.stream(numbers).boxed().sorted((num1, num2) -> {
            char[] c1 = Integer.toString(num1).toCharArray();
            char[] c2 = Integer.toString(num2).toCharArray();
            
            // 두 수사이에 작은 것이 있다면
            for(int i = 0; i < Math.min(c1.length, c2.length); i++){
                if(c1[i] != c2[i]) return c2[i] - c1[i];
            }
            
            if(c1.length == c2.length) return 0;
            
            // 길이가 한쪽이 길고, 같은 값으로만 이루어져 있다면
            for(int i = Math.min(c1.length, c2.length); i < Math.max(c1.length, c2.length); i++){
                int minIdx = i - Math.min(c1.length, c2.length);
                
                // if(minIdx >= Math.min(c1.length, c2.length)) break;
                // c2를 검토
                if(c1.length < c2.length){
                    if(c1[minIdx] != c2[i]) return c2[i] - c1[minIdx];
                }else if(c1.length > c2.length){
                    if(c1[i] != c2[minIdx]) return c2[minIdx] - c1[i];
                }
            }
            
            return c2.length - c1.length;

        }).mapToInt(Integer::intValue).toArray();
        
        
        StringBuilder builder = new StringBuilder();
        for(int num : numbers){
            builder.append(num);
        }
        
        return builder.toString();
    }
}