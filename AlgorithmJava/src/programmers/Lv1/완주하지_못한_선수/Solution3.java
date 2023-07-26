package programmers.Lv1.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < participant.length; i++){
            map.putIfAbsent(participant[i], 0);
            map.put(participant[i], map.get(participant[i]) + 1);
        }

        for(int i = 0; i < completion.length; i++){
            int cnt = map.get(completion[i]);
            if(cnt == 1) map.remove(completion[i]);
            else map.put(completion[i], cnt - 1);
        }

        // System.out.println(map.size());
        return map.keySet().stream().iterator().next();
    }
}
