package programmers.LV2.다음_큰_숫자;


// 효율성이 좋지 못한 코드 70점
//class Solution {
//
//    // 0과 1의 자리를 바꾸기 위해서 사용한 함수
//    String inputStr(int zero, int one){
//        String s = "";
//
//        for(int i = 0; i < one-1; i++) s += '1';
//        for(int i = 0; i < zero+1; i++) s += '0';
//        s += '1';
//        return s;
//    }
//
//    public int solution(int n) {
//        int answer = 0;
//        boolean check = false;
//        int zeroCnt = 0;
//        int oneCnt = 0;
//        String strN = "";
//        // 이진수로 변경
//        while(n > 1){
//            // 만약 n % 2가 0이고 아직 check 하는 상태라면
//            int mod = n % 2;
//            n /= 2;
//            if(mod == 0 && !check && oneCnt == 0){
//                zeroCnt += 1;
//            }else if(mod == 0 && !check && oneCnt > 0){
//                // 만약 0인데, 1을 체크한 경우면 현재 위치로 부터
//                // 맨 뒤에 있는 0과 추가 0을 사이에 넣어야 한다.
//                // 00111100
//                // 01000111
//                strN += inputStr(zeroCnt, oneCnt);
//                check = true;
//            }else if(mod == 1 && !check){
//                oneCnt += 1;
//            }else{
//                strN += (mod == 0 ? '0' : '1');
//            }
//        }
//
//        // 마지막 1추가
//        if(check) strN += '1';
//        else strN += inputStr(zeroCnt, oneCnt+1);
//
//        int twoSquare = 1;
//        for(char c : strN.toCharArray()){
//            answer += twoSquare * (c-'0');
//            twoSquare *= 2;
//        }
//
//        return answer;
//    }
//}




// 효율성 개선 코드
class Solution {
    public int solution(int n) {
        int answer = 0;
        int count = binary(n);
        int index = 1;
        while (true) {
            int number = n + index;
            if (count == binary(number)) {
                answer = number;
                break;
            }
            index++;
        }
        return answer;
    }

    public int binary(int x){
        String s = Integer.toBinaryString(x);
        int count = 0;
        for(char c : s.toCharArray()){
            if(c == '1') count++;
        }
        return count;
    }
}