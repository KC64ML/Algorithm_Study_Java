package programmers.LV2.최대값과_최솟값;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] s_arr = s.split(" ");

        int maxData = Integer.MIN_VALUE;
        int minData = Integer.MAX_VALUE;

        for(String in_s_arr : s_arr){
            int curIdxData = Integer.parseInt(in_s_arr);
            minData = Math.min(minData, curIdxData);
            maxData = Math.max(maxData, curIdxData);
        }

        answer += minData + " " + maxData;
        return answer;
    }
}