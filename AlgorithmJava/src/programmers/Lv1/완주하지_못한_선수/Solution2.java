package programmers.Lv1.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class Solution2 {


    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> count = new HashMap<>();

        for(String inParticipant : participant){
            count.putIfAbsent(inParticipant, 0);
            count.put(inParticipant, count.get(inParticipant) + 1);
        }

        for(String inCompletion : completion){
            // 0인경우 remove,
            // 1이상인 경우 get으로 꺼낸 것 - 1
            count.put(inCompletion, count.get(inCompletion) - 1);
            if(count.get(inCompletion) == 0) count.remove(inCompletion);
        }

        return count.keySet().iterator().next();
    }


    public static void main(String[] args) {

    }
}
