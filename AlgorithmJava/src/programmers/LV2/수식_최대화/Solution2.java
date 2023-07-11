package programmers.LV2.수식_최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import java.util.*;

import java.util.*;

public class Solution2 {

    private final String[][] operators = {
            "*+-".split(""),
            "*-+".split(""),
            "-*+".split(""),
            "-+*".split(""),
            "+*-".split(""),
            "+-*".split("")
    };

    private boolean operatorCheck(String s){
        return s.equals("*") || s.equals("+") || s.equals("-");
    }

    private long calculate(long number1, long number2, String operator){
        switch(operator){
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

    private long calculate(String[] operator, List<String> list){
        for(String c : operator){
            for(int i = 0; i < list.size(); i++){
                String curData = list.get(i);
                // System.out.println("curData : " + curData + " " + c + " " + curData.equals(c));
                if(operatorCheck(curData) && curData.equals(c)){
                    long number1 = Long.parseLong(list.get(i - 1));
                    long number2 = Long.parseLong(list.get(i + 1));
                    long nextData = calculate(number1, number2, curData);
                    // System.out.println("계산식 : " + number1 + " " + number2 + " "  + nextData);
                    // System.out.println("nextData : " + nextData);
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.remove(i - 1);
                    list.add(i - 1, String.valueOf(nextData));
                    i -= 2;
                }
            }
        }

        return Long.parseLong(list.get(0));
    }

    public long solution(String expression) {

        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
        }


        long answer = 0;
        for(String[] operator : operators){
            long result = Math.abs(calculate(operator, new ArrayList<>(list)));
            answer = Math.max(result, answer);
        }

        return answer;
    }
}
