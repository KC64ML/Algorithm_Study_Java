package programmers.LV3.네트워크;

import java.util.Stack;

public class Solution2 {

    private boolean[] visited;

    private void network(int index, int[][] computers, int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while(!stack.isEmpty()){
            int curIndex = stack.pop();

            for(int i = 0; i < n; i++){
                if(computers[curIndex][i] == 0) continue;
                if(visited[i]) continue;
                visited[i] = true;
                stack.push(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;
        for(int i = 0 ; i < n; i++){
            if(visited[i]) continue;
            network(i, computers, n);
            answer += 1;
        }

        return answer;
    }
}
