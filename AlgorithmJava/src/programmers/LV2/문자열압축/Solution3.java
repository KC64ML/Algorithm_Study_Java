package programmers.LV2.문자열압축;

import java.util.*;

public class Solution3 {

    private List<String> split(String s, int cutLen){

        int endIndex = 0;

        List<String> token = new ArrayList<>();
        // System.out.println("자르는 구간");
        for(int startIndex = 0; startIndex < s.length(); startIndex += cutLen){
            endIndex += cutLen;
            if(endIndex > s.length()) endIndex = s.length();
            // 문자열 자르기 한 후, List에 추가
            // System.out.println("startIndex : " + startIndex + " endIndex : " + endIndex);
            token.add(s.substring(startIndex, endIndex));
        }

        return token;
    }

    private int sliceInterval(String s, int cutLen){

        int count = 0;
        String result = "";
        String beforeToken = "";

        for(String token : split(s, cutLen)){
            // System.out.println("for문 시작");
            // System.out.println("token : " + token);
            if(token.equals(beforeToken)) count += 1;
            else{
                if(count > 1) result += count;
                count = 1;
                result += beforeToken;
                beforeToken = token;
            }
        }

        if(count > 1) result += count;
        result += beforeToken;

        // System.out.println("정리 후 결과 : " + result);
        return result.length();
    }

    public int solution(String s) {

        int answer = Integer.MAX_VALUE;

        for(int cutLen = 1; cutLen <= s.length() / 2 + 1; cutLen++){
            answer = Math.min(answer, sliceInterval(s, cutLen));
        }

        return answer;
    }
}