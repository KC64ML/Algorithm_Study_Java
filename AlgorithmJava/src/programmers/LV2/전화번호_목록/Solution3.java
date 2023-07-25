package programmers.LV2.전화번호_목록;

import java.util.*;

public class Solution3 {
    public boolean solution(String[] phoneBook) {
        Set<String> set = new HashSet<>();

        for(String inPhoneBook : phoneBook){
            for(int end = 1; end < inPhoneBook.length(); end++) set.add(inPhoneBook.substring(0, end));
        }

        for(String inPhoneBook : phoneBook){
            if(set.contains(inPhoneBook)) return false;
        }

        return true;
    }
}
