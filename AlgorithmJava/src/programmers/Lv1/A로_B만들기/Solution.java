package programmers.Lv1.A로_B만들기;

import java.util.Map;
import java.util.HashMap;

public class Solution {

    private static Map<Character, Integer> toMap(String word){
        Map<Character, Integer> map = new HashMap<>();

        for(char c : word.toCharArray()){
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    public int solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
}
