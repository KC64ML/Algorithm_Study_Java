package programmers.LV2.이진_변환_반복하기;

import java.util.Arrays;
import java.util.Iterator;

class Solution {
    static int[] solution(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            System.out.println("s : " + s );
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;
    }


    // 문자열안에 문자 길이
    static int countChar(String str, char ch){
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(solution(s));
    }
}