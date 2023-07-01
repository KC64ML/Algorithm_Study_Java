package programmers.LV2.전화번호_목록;

import java.util.*;

public class Solution {
    public boolean solution(String[] phone_book) {

        Set<String> set = new HashSet<>();

        for(String inPhoneBook : phone_book) {
            for(int end = 1; end < inPhoneBook.length(); end++){
                set.add(inPhoneBook.substring(0, end));
            }
        }

        for(String inPhoneBook : phone_book) {
            if(set.contains(inPhoneBook)) return false;
        }

        return true;
    }
}
