import java.util.*;

class Solution {
    private long sum, sum2;
    private long totalSum;
    public int solution(int[] que, int[] que2) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        
        for(int i = 0; i < que.length; i++){
            queue.add(que[i]);
            sum += que[i];
        }
        
        for(int i = 0; i < que2.length; i++){
            queue2.add(que2[i]);
            sum2 += que2[i];
        }
        
        
        int answer = 0;
        if(sum == sum2) return 0;
        totalSum = sum + sum2;
        
        for(int i = 0; i < que.length * 4; i++){
            if(sum > sum2){
                int curData = queue.poll();
                queue2.add(curData);
                sum2 += curData;
                sum -= curData;
            }else if(sum < sum2) {
                int curData = queue2.poll();
                queue.add(curData);
                sum2 -= curData;
                sum += curData;
            }else{
                break;
            }
            
            answer += 1;
            
            if(i == que.length * 4 - 1) answer = -1;
        }
        
        return answer;
    }
}