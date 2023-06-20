package programmers.Lv1.이상한_문자_만들기;

public class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;

        for(char c : s.toCharArray()){
            if(!Character.isAlphabetic(c)){
                sb.append(c);
                toUpper = true;
            }else {
                if(toUpper) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
                toUpper = !toUpper;
            }
        }

        answer = sb.toString();

        return answer;
    }
}
