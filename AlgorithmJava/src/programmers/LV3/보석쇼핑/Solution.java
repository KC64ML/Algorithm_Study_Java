package programmers.LV3.보석쇼핑;

import java.util.*;

public class Solution {
    // 이미 구간에 보석이 모두 포함된 상태라면 시작점을 옮김
    // 구간에 보석이 모두 포함된 상태가 아니라면 끝점을 옮긴다.

    public int[] solution(String[] gems) {
        int start = 0;
        int end = gems.length - 1;

        Set<String> gemSet = new HashSet<>(List.of(gems));

        int s = 0;
        int e = s;

        Map<String, Integer> includes = new HashMap<>();
        includes.put(gems[s], 1);

        while (s < gems.length){
            // 체크하는 구간
            if(includes.keySet().size() == gemSet.size()){

                // 더 좁은 구간이라면
                if (e - s < end - start) {
                    start = s;
                    end = e;
                }

                // 시작지점 - 1
                includes.put(gems[s], includes.get(gems[s]) - 1);

                // 제거
                if(includes.get(gems[s]) == 0) {
                    includes.remove(gems[s]);
                }
                s++;
            } else if (e < gems.length - 1) {
                e++;
                includes.put(gems[e], includes.getOrDefault(gems[e], 0) + 1);
            } else {
                break;
            }
        }

        return new int[]{start + 1, end + 1};
    }
}
