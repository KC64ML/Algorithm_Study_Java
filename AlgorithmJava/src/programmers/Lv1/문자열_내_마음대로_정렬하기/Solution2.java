package programmers.Lv1.문자열_내_마음대로_정렬하기;

import java.util.Arrays;

public class Solution2 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (c1, c2)-> {
            if(c1.charAt(n) != c2.charAt(n)) return c1.charAt(n) - c2.charAt(n);
            return c1.compareTo(c2);
        });

        return strings;
    }
}
