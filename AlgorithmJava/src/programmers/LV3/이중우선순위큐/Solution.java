package programmers.LV3.이중우선순위큐;

import java.util.*;

public class Solution {

    private static class DoublePriorityQueue{
        public PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        public PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        public int size;

        public void add(int number){
            maxPQ.add(number);
            minPQ.add(number);
            size += 1;
        }

        public void removeMax(){
            if(size == 0) return;
            maxPQ.poll();
            if(--size == 0){
                maxPQ.clear();
                minPQ.clear();
            }
        }

        public void removeMin(){
            if(size == 0) return;
            minPQ.poll();
            if(--size == 0){
                maxPQ.clear();
                minPQ.clear();
            }
        }

        public int max(){
            if(size == 0) return 0;
            return maxPQ.peek();
        }

        public int min(){
            if(size == 0) return 0;
            return minPQ.peek();
        }
    }

    public int[] solution(String[] operations) {
        DoublePriorityQueue pq = new DoublePriorityQueue();

        for(String operation : operations){
            String[] s = operation.split(" ");
            if(operation.startsWith("I")){
                pq.add(Integer.parseInt(s[1]));
            }else{
                switch(s[1]){
                    case "1":
                        pq.removeMax();
                        break;
                    case "-1":
                        pq.removeMin();
                        break;
                }
            }
        }

        return new int[]{pq.max(), pq.min()};
    }
}
