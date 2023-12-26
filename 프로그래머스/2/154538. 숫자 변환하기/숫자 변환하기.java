import java.util.*;

class Node{
    int y;
    int cnt;
    
    Node(int y, int cnt){
        this.y = y;
        this.cnt = cnt;
    }
}

class Solution {
    
    int x, n;
    int answer;
    
    public int solution(int _x, int y, int _n) {
        answer = Integer.MAX_VALUE;
        x = _x;
        n = _n;
        
        Queue<Node> queue = new ArrayDeque();
        queue.add(new Node(y, 0));
        
        while(queue.size() > 0){
            Node node = queue.poll();

            // 같다면 종료
            if(node.y == x){
                answer = Math.min(answer, node.cnt);
                break;
            }
            
            if(node.y % 3 == 0 && node.y / 3 >= x) queue.add(new Node(node.y / 3, node.cnt+1));
            if(node.y % 2 == 0 && node.y / 2 >= x) queue.add(new Node(node.y / 2, node.cnt+1));
            if(node.y - n >= x) queue.add(new Node(node.y - n, node.cnt + 1));
        }
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}