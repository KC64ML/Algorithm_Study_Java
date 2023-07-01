package programmers.Lv1.중복된_문자제거;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String solution(String myString) {
        StringBuilder builder = new StringBuilder();
        Set<Character> used = new HashSet<>();

        for(char c : myString.toCharArray()){
            if(used.contains(c)) continue;
            used.add(c);
            builder.append(c);
        }

        return builder.toString();
    }
}
