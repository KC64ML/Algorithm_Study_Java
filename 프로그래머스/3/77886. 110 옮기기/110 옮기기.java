import java.util.*;


class Solution {
    public ArrayList<String> solution(String[] s) {
        
        ArrayList<String> answer = new ArrayList<>();
        int idx = 0;
        for(String inS : s){
            // System.out.println("index : " + (idx++));
            char[] cArr = inS.toCharArray();
            Stack<Character> stack = new Stack<>();
            int pos110 = 0;
            
            for(int i = 0; i < cArr.length; i++){
                stack.push(cArr[i]);
                
                if(stack.size() >= 3){
                    
                    // (1) 첫 번째가 0이 아닐 때
                    char first = stack.pop();
                    if(first != '0'){
                        stack.push(first);
                        continue;
                    }
                    
                    
                    // (2) 두 번째가 1이 아닐 때
                    char second = stack.pop();
                    if(second != '1'){
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    
                    // (3) 세 번째가 1이 아닐 때
                    char third = stack.pop();
                    if(third != '1'){
                        stack.push(third);
                        stack.push(second);
                        stack.push(first);
                        continue;
                    }
                    
                    pos110++;
                }
            }
            
            boolean flag = false;
            int posSize = stack.size();
            StringBuilder builder = new StringBuilder();
            
            // stack 크기 만큼 반복문을 돌린다.
            // 0이 아직 나오지 않았다면 110 들어갈 위치를 앞으로 땡긴다.
            while(stack.size() > 0){
                char c = stack.pop();
                if(!flag && c == '1') posSize--;
                if(c == '0') flag = true;
                builder.insert(0, c);
            }
            
            for(int i = 0; i < pos110; i++){
                builder.insert(posSize, "110");
            }
            
            answer.add(builder.toString());
        }
        
        return answer;
    }
}