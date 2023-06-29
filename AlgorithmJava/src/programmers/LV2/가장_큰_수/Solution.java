package programmers.LV2.가장_큰_수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(int[] numbers) {
        // 문자열로 바꾸고, 합쳐서 비교
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    int original = Integer.parseInt(s1 + s2);
                    int reversed = Integer.parseInt(s2 + s1);
                    // 양수를 반환하면 s2가 앞으로 가야 한다.
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }
}
