package programmers.LV2.수식_최대화;

import java.util.*;

public class Solution {

    // (1) 연산자 우선순위
    private static final String[][] operatorList = {
            "*-+".split(""),
            "*+-".split(""),
            "+*-".split(""),
            "+-*".split(""),
            "-+*".split(""),
            "-*+".split("")
    };

    // (2) 숫자1, 숫자2, 연산자가 넘어왔을 때 계산하기
    private long calculator(long leftNumber, long rightNumber, String operator){
        long result = 0;
        switch(operator){
            case "+":
                result = leftNumber + rightNumber;
                break;
            case "-":
                result = leftNumber - rightNumber;
                break;
            case "*":
                result = leftNumber * rightNumber;
                break;
            default:
                result = 0;
                break;
        };
        return result;
    }

    // (3) expression 계산 함수
    private long checkExpression(List<String> modify, String[] operator){
        for(String oper : operator){
            for(int modifyIndex = 0; modifyIndex < modify.size(); modifyIndex++){
                if(modify.get(modifyIndex).equals(oper)){
                    long lns = Long.parseLong(modify.get(modifyIndex - 1));
                    long rns = Long.parseLong(modify.get(modifyIndex + 1));
                    long expressionResult = calculator(lns, rns, oper);

                    // 앞에 숫자, 뒤에 숫자, 가운데 연산자 제거 (새로 업데이트 하기 위함)
                    modify.remove(modifyIndex - 1);
                    modify.remove(modifyIndex - 1);
                    modify.remove(modifyIndex - 1);
                    modify.add(modifyIndex - 1, String.valueOf(expressionResult));
                    modifyIndex -= 2;
                }
            }
        }
        return Long.parseLong(modify.get(0));
    }

    public long solution(String expression) {
        long max = 0;
        StringTokenizer token = new StringTokenizer(expression, "*+-", true);
        List<String> modify = new ArrayList<>();

        while(token.hasMoreTokens()){
            modify.add(token.nextToken());
        }

        for(String[] operator : operatorList){
            long result = Math.abs(checkExpression(new ArrayList<>(modify), operator));

            if(max < result){
                max = result;
            }
        }

        return max;
    }
}