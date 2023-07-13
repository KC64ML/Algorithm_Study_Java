package programmers.LV2.전화번호_목록;

import java.util.*;

public class Solution2 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();


        for(String book : phone_book){
            for(int end = 1; end < book.length(); end++){
                set.add(book.substring(0, end));
            }
        }

        for(String book : phone_book) {
            if(set.contains(book)) return false;
        }

        return true;
    }
}
