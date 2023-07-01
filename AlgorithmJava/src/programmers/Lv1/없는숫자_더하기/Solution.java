package programmers.Lv1.없는숫자_더하기;

import java.util.Set;
import java.util.HashSet;

public class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int v : numbers){
            set.add(v);
        }

        int sum = 0;

        for(int n = 0; n <= 9; n++){
            if(set.contains(n)) continue;
            sum += n;
        }

        return sum;
    }
}
