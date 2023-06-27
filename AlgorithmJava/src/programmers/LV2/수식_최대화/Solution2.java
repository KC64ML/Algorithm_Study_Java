package programmers.LV2.수식_최대화;

import java.util.StringTokenizer;

public class Solution2 {
    public static void main(String[] args) {
        String expression = "1+2*3-4+5*6-7*8+9";
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
