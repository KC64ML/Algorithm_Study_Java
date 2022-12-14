package programmers.LV2.영어_끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> list = new ArrayList<>();
        int cnt = 1;
        int people = 1;
        String before = "";

        for(int i = 0; i < words.length; i++){
            // 만약 포함되어 있거나, 이전 마지막 char과 이번 첫번째 char이 다르다면 out
            if(list.contains(words[i]) || (i > 0 && before.charAt(before.length() - 1) != words[i].charAt(0))){
                // System.out.println("people : " + people + " cnt : " + cnt + " before : " + before + " words : " +words[i]);
                answer[0] = people;
                answer[1] = cnt;
                break;
            }else{
                list.add(words[i]);
            }
            people += 1;
            before = words[i];

            if((i + 1) % n == 0){
                // 번호 초기화, 다음 차례
                cnt += 1;
                people = 1;
            }
        }
        return answer;
    }
}