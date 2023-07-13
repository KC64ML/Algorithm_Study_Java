package programmers.Lv1.A로_B만들기;

import java.util.*;


public class Solution2 {

    private static Map<Character, Integer> toMap(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            // 비어있다면 아직 넣은 적이 없을 경우, 1으로 넣기
            map.putIfAbsent(c, 1);
            map.put(c, map.get(c) + 1);
        }

        return map;
    }

    public int solution(String before, String after) {
        // map으로 equals 처리하기
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
}
