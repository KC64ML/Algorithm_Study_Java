package programmers.Lv1.두개_뽑아서_더하기;

import java.util.*;

public class Solution2 {
    public int[] solution(int[] numbers) {
        Set<Integer> answer = new HashSet<>();

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                // System.out.println("i : " + numbers[i] + " j : " + numbers[j]);
                answer.add(numbers[i] + numbers[j]);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}