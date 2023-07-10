package programmers.LV2.이진_변환_반복하기;

public class Solution3 {

    private int[] removeZero(String s){
        StringBuilder builder = new StringBuilder();

        char[] c = s.toCharArray();
        int zeroCnt = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '0') zeroCnt += 1;
        }

        // 1의 개수, 0의 개수
        return new int[]{s.length() - zeroCnt, zeroCnt};
    }

    public int[] solution(String s) {

        int zeroCnt = 0;
        int count = 0;
        while(s.length() > 1){
            int[] result = removeZero(s);
            s = Integer.toString(result[0], 2);
            zeroCnt += result[1];
            count += 1;
        }

        return new int[]{count, zeroCnt};
    }
}
