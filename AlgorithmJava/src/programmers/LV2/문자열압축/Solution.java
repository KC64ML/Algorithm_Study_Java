package programmers.LV2.문자열압축;

import java.util.*;

public class Solution {

    // split : 분열 함수
    List<String> split(String s, int length) {
        List<String> token = new ArrayList<>();
        int sLength = s.length();

        for (int startIndex = 0; startIndex < sLength; startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > sLength) endIndex = sLength;
            token.add(s.substring(startIndex, endIndex));
        }
        return token;
    }

    // 비교하는 compress 압축 함수
    int compress(String s, int length) {
        String lastData = "";
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (String token : split(s, length)) {
            // 만약 현재 token와 lastData가 같다면 같은지 판단하는 횟수 증가
            if (token.equals(lastData)) count++;
            else {
                if (count > 1) builder.append(count);
                builder.append(lastData);
                count = 1;
                lastData = token;
            }
        }

        // 끝난 후에도 저장되어 있다면
        if (count > 1) builder.append(count);
        builder.append(lastData);

        // System.out.println(builder.toString());

        return builder.length();
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;


        // 문자열 길이 절반을 기준으로 찾는다.
        for (int length = 1; length < s.length() / 2 + 1; length++) {
            // 문자열 잘라서 반환
            int truncatedLen = compress(s, length);
            if (truncatedLen < answer) answer = truncatedLen;
        }

        if (answer == Integer.MAX_VALUE) answer = s.length();

        return answer;
    }
}
