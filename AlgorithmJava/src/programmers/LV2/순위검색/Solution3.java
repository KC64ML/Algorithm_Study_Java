package programmers.LV2.순위검색;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {
        String[] s = {"Abs", "Bcd", "De"};
        String[] s2 = Arrays.copyOfRange(s, 0, s.length);

        System.out.println(Arrays.deepToString(s2));
    }
}
