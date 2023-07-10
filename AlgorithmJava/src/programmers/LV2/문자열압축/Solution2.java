package programmers.LV2.문자열압축;

import java.util.*;

public class Solution2 {

    private List<String> split(String s, int cutLen){

        int endIndex = 0;
        List<String> token = new ArrayList<>();

        for(int startIndex = 0; startIndex < s.length(); startIndex += cutLen){
            endIndex = startIndex + cutLen;
            if(endIndex > s.length()) endIndex = s.length();
            token.add(s.substring(startIndex, endIndex));
        }

        return token;
    }

    private String compass(String s, int length){
        int count = 0;
        String lastData = new String();
        StringBuilder builder = new StringBuilder();
        for(String token : split(s, length)){
            if(token.equals(lastData)) count += 1;
            else{
                if(count > 1) builder.append(count);
                count = 1;
                builder.append(lastData);
                lastData = token;
            }
        }

        if(count > 1) builder.append(count);
        builder.append(lastData);

        return builder.toString();
    }

    public int solution(String s) {

        int length = s.length();

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < length / 2 + 1; i++){

            // compass 함수를 통해 문자열 길이를 반환해 결과가 가장 짧은 것이 정답이다.
            answer = Math.min(answer, compass(s, i).length());

        }

        if(answer == Integer.MAX_VALUE) answer = s.length();

        return answer;
    }
}
