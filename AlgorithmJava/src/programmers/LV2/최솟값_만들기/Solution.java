package programmers.LV2.최솟값_만들기;

import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        Integer[] intB = new Integer[B.length];

        for(int i =0; i< B.length; i++){
            intB[i] = B[i];
        }

        Arrays.sort(A);
        Arrays.sort(intB, (x, y) -> (y - x)); // 역 정렬


        for(int i =0 ; i< A.length; i++){
            answer += (A[i] * intB[i]);
        }

        return answer;
    }
}