package programmers.Lv1.없는숫자_더하기;

import java.util.Arrays;



public class Solution2 {
    public int solution(int[] numbers) {

        // 1 ~ 10 : 55
        int sum = 45;

        for(int num : numbers) sum -= num;


        return sum;
    }
}
