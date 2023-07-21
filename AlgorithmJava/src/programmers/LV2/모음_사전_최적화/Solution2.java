package programmers.LV2.모음_사전_최적화;

import java.util.List;
import java.util.ArrayList;

public class Solution2 {

    private char[] alpha = {'A', 'E', 'I', 'O', 'U'};

    private void vowel(String s, List<String> list){
        if(s.length() == alpha.length + 1) return;

        list.add(s);

        for(int i = 0; i < 5; i++){
            vowel(s + alpha[i], list);
        }
    }

    public int solution(String word) {
        ArrayList<String> list = new ArrayList<>();
        vowel("", list);

        return list.indexOf(word);
    }
}