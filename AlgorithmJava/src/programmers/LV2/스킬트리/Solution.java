package programmers.LV2.스킬트리;

import java.util.Arrays;

public class Solution {
    public int solution(String skill, String[] skillTrees) {
        return (int) Arrays.stream(skillTrees)
                .map(s -> s.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }
}
