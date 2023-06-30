package programmers.LV2.순위검색;

import java.util.*;
import java.util.function.Consumer;

public class Solution {
    private void forEachKey(int index, String prefix, String[] tokens,
                            Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]); // 점수
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        // scoresMap에는 forEachKey 메서드를 통해 생성된 모든 키의 경우의 수에 해당하는 값이 저장되어 있다.
        /*
        String[] info = {
          "java backend junior pizza 150",
          "python frontend senior chicken 210",
          "python frontend senior chicken 150",
          "cpp backend senior pizza 260",
          "java backend junior chicken 80",
          "python backend senior chicken 50"
        };


        결과
        scoresMap = {
          "javabackendjuniorpizza": [150],
          "pythonfrontendseniorchicken": [210, 150],
          "cppbackendseniorpizza": [260],
          "javabackendjuniorchicken": [80],
          "pythonbackendseniorchicken": [50]
        }

        * */

        return scoresMap;
    }

    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;  // inclusive
        int end = scores.size() - 1;  // inclusive

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < score) {
            // List<Integer> scores = Arrays.asList(10, 30, 50, 70, 90);
            //int score = 95;
            // 위와 같은 경우 실행된다.
            return scores.size();
        }

        return start;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");

        String key
                = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length - 1]);

        // score 점수보다 모두 작으면 경우의 수가 없는 것이다.
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = new int[query.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count(query[i], scoresMap);
        }
        return answer;
    }
}