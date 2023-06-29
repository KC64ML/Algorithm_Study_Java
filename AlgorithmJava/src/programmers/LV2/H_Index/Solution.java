package programmers.LV2.H_Index;

import java.util.Arrays;

public class Solution {

    private boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        return citations[index] >= h;
    }

    public int solution(int[] citations) {
        int answer = 0;

        // 정렬
        Arrays.sort(citations);
        // citations을 마지막 인덱스 부터 검토한다.
        for(int h = citations.length; h >= 1; h--){
            if(isValid(citations, h)) return h;
        }
        return 0;
    }
}
