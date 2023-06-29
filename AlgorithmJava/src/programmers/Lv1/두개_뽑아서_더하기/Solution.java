package programmers.Lv1.두개_뽑아서_더하기;

import java.util.Set;
import java.util.HashSet;

public class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}
