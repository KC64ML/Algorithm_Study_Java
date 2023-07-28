package programmers.LV2.스킬트리;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Arrays;

public class Solution2 {
    public int solution(String skill, String[] skillTree) {
        return (int)Arrays.stream(skillTree)
                .map(p -> p.replaceAll("[^" + skill +"]", ""))
                .filter(skill::startsWith)
                .count();
    }
}
