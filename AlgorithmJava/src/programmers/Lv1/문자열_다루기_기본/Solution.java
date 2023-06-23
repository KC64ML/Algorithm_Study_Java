package programmers.Lv1.문자열_다루기_기본;

public class Solution {
    public boolean solution(String s) {
        return s.matches("[0-9]{4}|[0-9]{6}");
    }
}