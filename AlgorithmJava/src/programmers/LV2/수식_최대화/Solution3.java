package programmers.LV2.수식_최대화;

import java.util.*;

public class Solution3 {

    private String[][] CODE = {
            "*+-".split(""),
            "*-+".split(""),
            "+*-".split(""),
            "+-*".split(""),
            "-+*".split(""),
            "-*+".split("")
    };

    private long calculate(long number1, long number2, String inCode){
        switch(inCode){
            case "*":
                return number1 * number2;
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            default:
                return 0;
        }
    }

    private long calculate(String[] inArrCode, List<String> list){
        for(String inCode : inArrCode){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).equals(inCode)){
                    long number1 = Long.parseLong(list.get(i - 1));
                    long number2 = Long.parseLong(list.get(i + 1));
                    long nextData = calculate(number1, number2, list.get(i));
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.remove(i - 1);
                    // System.out.println("left : " + number1 + " , right : " + number2  + " 결과 : " + nextData);
                    list.add(i - 1, Long.toString(nextData));
                    i -= 2;
                }
            }
        }


        return Math.abs(Long.parseLong(list.get(0)));
    }

    public long solution(String expression) {
        StringTokenizer tokenizer = new StringTokenizer(expression, "*+-", true);

        List<String> list = new ArrayList<>();
        long answer = 0;

        while(tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }

        for(String[] inArrCode : CODE){
            answer = Math.max(answer, calculate(inArrCode, new ArrayList<>(list)));
        }

        return answer;
    }
}
