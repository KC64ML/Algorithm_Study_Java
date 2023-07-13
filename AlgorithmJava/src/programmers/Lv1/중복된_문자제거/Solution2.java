package programmers.Lv1.중복된_문자제거;

import java.util.*;
import java.util.stream.Collectors;

import java.util.*;

public class Solution2 {
    public String solution(String my_string) {
        Set<Character> set = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for(char c : my_string.toCharArray()){
            if(set.contains(c)) continue;
            set.add(c);
            builder.append(c);
        }

        return builder.toString();
    }
}