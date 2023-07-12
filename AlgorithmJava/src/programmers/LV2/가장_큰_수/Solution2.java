package programmers.LV2.가장_큰_수;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    public String solution(int[] numbers) {
        // IntStream -> Stream<Int>
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((num1, num2) -> {
                    int s1 = Integer.parseInt(num1 + num2);
                    int s2 = Integer.parseInt(num2 + num1);

                    // 음수 : 순서 변경되지 않는다.
                    // s2가 s1보다 작으면 변경되지 않는다.
                    // 0 : 순서 변경되지 않는다.
                    // 양수 : 순서 변경된다.

                    // 내림차순이므로 순서가 이와 같다.
                    return s2 - s1;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }
}