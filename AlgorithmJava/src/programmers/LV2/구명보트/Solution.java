package programmers.LV2.구명보트;

import java.util.*;


// 효율성이 좋지 못한 코드 75점
//class Solution {
//
//    int[] people;
//    int limit;
//    int answer;
//
//    int swap(int a, int b){
//        return a;
//    }
//
//
//    void boat(int startIdx, int lastIdx, int cnt){
//        // System.out.println("start : " + startIdx + " lastIdx : " + lastIdx + "cnt : " + cnt);
//        int sum = people[startIdx];
//        int i = lastIdx;
//        for(; i > startIdx; i--){
//            // System.out.println("i : " + i + " people" + people[i]);
//            if(sum + people[i] <= limit) sum += people[i];
//            else break;
//        }
//
//        if(i == startIdx){
//            answer = cnt;
//            return;
//        }else{
//            boat(startIdx+1, i, cnt + 1);
//        }
//    }
//
//    public int solution(int[] _people, int _limit) {
//
//        people = _people;
//        limit = _limit;
//        // 역정렬
//        for(int i =0; i< people.length; i++){
//            for(int j =i+1; j < people.length; j++){
//                if(people[i] < people[j]) people[j] = swap(people[i], people[i]=people[j]);
//            }
//        }
//
//        if(people.length > 1 && (people[people.length-1] + people[people.length-2] > _limit)) return people.length;
//
//        boat(0, people.length - 1, 1);
//
//        return answer;
//    }
//}


// 답안 코드
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int p : people) list.add(p);
        Collections.sort(list);


        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i : list) deque.add(i);

        while(deque.size() > 0){
            int n = deque.pollLast();
            if(deque.size() > 0 && n + deque.peekFirst() <= limit) deque.pollFirst();
            answer += 1;
        }

        return answer;
    }
}