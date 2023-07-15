package programmers.LV3.단어_변환;

import java.util.Stack;


public class Solution2 {

    private boolean[] visited;

    private boolean wordAlphaCheck(char[] word1, char[] word2){
        int count = 0;
        for(int i = 0; i < word1.length; i++) {
            if(word1[i] == word2[i]) count++;
        }

        return count == (word1.length - 1);
    }

    private boolean isTargetInWords(String target, String[] words){
        for(String word : words){
            if(target.equals(word)) return true;
        }
        return false;
    }

    private int wordCheck(String begin, String target, String[] words){
        Stack<int[]> stack = new Stack<>();

        // 첫 번째 시작 위치 찾기
        for(int i = 0; i < words.length; i++){
            if(wordAlphaCheck(begin.toCharArray(), words[i].toCharArray())){
                stack.push(new int[]{i, 1});
                break;
            }
        }

        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            int curIdx = arr[0];

            visited[curIdx] = true;

            if(words[curIdx].equals(target)){

                return arr[1];
            }

            for(int i = 0; i < words.length; i++){
                if(!wordAlphaCheck(words[curIdx].toCharArray(), words[i].toCharArray())) continue;
                if(visited[i]) continue;
                stack.push(new int[]{i, arr[1] + 1});
            }
        }

        return words.length;
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        // target이 words안에 없을 때
        if(!isTargetInWords(target, words)) return 0;

        return wordCheck(begin, target, words);

    }
}
