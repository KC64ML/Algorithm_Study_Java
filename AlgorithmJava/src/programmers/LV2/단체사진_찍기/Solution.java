package programmers.LV2.단체사진_찍기;

class Solution {

    char[] people = {'A','C','F','J','M','N','R','T'};
    boolean[] visited;
    int answer;

    boolean checkComb(String combPeop, String[] data){
        for(String inData : data){
            // 꺼내서 확인 : 0번, 2번, 3번, 4번 확인한다.
            // 0, 2번 거리 값 구함
            // 3번 =, >, < 확인
            // 4번 거리
            int people1 = combPeop.indexOf(inData.charAt(0));
            int people2 = combPeop.indexOf(inData.charAt(2));
            char operator = inData.charAt(3);
            int range = inData.charAt(4) - '0' + 1;
            // System.out.println("삽입한 결과 : " + combPeop);
            // System.out.println("실행결과 : " + people1 + " " + people2 + " = " + range);
            if(operator == '=' && !(Math.abs(people1 - people2) == range)){
                return false;
            }else if(operator == '>' && !(Math.abs(people1 - people2) > range)){
                return false;
            }else if(operator == '<' && !(Math.abs(people1 - people2) < range)){
                return false;
            }
        }
        return true;
    }

    void backtracking(String combPeop ,String[] data){
        if(combPeop.length() == 8){
            // 확인한다.
            if(checkComb(combPeop, data)){
                answer += 1;
            }

            return;
        }

        for(int i =0 ; i< 8; i++){
            if(!visited[i]){
                visited[i] = true;
                backtracking(combPeop + people[i], data);
                visited[i] = false;
            }
        }

    }

    public int solution(int n, String[] data) {

        visited = new boolean[8];

        backtracking("", data);

        return answer;
    }
}