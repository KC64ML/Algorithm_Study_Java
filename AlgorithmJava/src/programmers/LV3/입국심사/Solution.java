package programmers.LV3.입국심사;

public class Solution {

    private boolean isValid(long t, int n , int[] times){
        long c = 0;
        for(int time : times){
            c += t / time;
        }

        return c >= n;
    }

    public long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000000000000L;

        while(start < end){
            long t = (start + end) / 2;

            // 범위에 포함될 시, end를 줄인다.
            if(isValid(t, n, times)){
                end = t;
            }else{
                // 범위에 포함되지 않을 시, start를 늘린다.
                start = t + 1;
            }
        }

        return start;
    }
}
