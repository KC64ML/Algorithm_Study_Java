package programmers.LV2.순위검색;

import java.util.Arrays;

import java.util.*;
import java.util.function.Consumer;

public class Solution2 {

    // info가 포함될 수 있는 모든 경우의 수를 map에 key로 넣고 점수를 value
    // query를 key로 하는 value들을 가져와서 이분탐색
    // 점수를 구할 때는 이분탐색을 한다.
    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action){
        if(index == tokens.length - 1){
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    // (1) info에 대한 모든 경우의 수 : buildScoreMap
    private Map<String, List<Integer>> buildScoreMap(String[] info){
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for(String inInfo : info){
            String[] tokens = inInfo.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);

            // forEachKey : info (점수를 제외) 가 포함될 수 있는 모든 경우의 수
            forEachKey(0, "", tokens, (key) -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }


        // 정렬
        for(List<Integer> list : scoresMap.values()){
            Collections.sort(list);
        }

        return scoresMap;
    }

    private int binarySearch(int score, List<Integer> scores){
        int start = 0;
        int end = scores.size() - 1;

        while(start < end){
            int mid = (start + end) / 2;

            if(scores.get(mid) >= score) end = mid;
            else start = mid + 1;
        }

        if(scores.get(start) < score) return scores.size();
        else return start;
    }

    private int count(Map<String, List<Integer>> scoresMap, String query){
        String[] tokens = query.split(" (and )?");

        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if(!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length - 1]);

        return scores.size() - binarySearch(score, scoresMap.get(key));

    }

    public int[] solution(String[] info, String[] query) {

        // info를 기준으로 모든 경우의 수를 구한다.
        Map<String, List<Integer>> scoresMap = buildScoreMap(info);

        int[] answer = new int[query.length];

        for(int i = 0; i < query.length; i++){
            answer[i] = count(scoresMap, query[i]);
        }

        return answer;
    }
}
