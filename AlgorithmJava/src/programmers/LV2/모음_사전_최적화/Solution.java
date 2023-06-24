package programmers.LV2.모음_사전_최적화;

import java.util.*;

public class Solution {

    private static final char[] CHARS = "AEIOU".toCharArray();

    private void generate(String word, List<String> words){
        words.add(word);

        if (word.length() == 5) return;
        for (char c : CHARS) {
            generate(word + c, words);
        }
    }

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
}
