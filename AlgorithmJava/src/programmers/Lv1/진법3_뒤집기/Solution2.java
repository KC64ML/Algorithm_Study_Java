package programmers.Lv1.진법3_뒤집기;

public class Solution2 {
    public int solution(int n) {


        String s = new StringBuilder().append(Integer.toString(n, 3)).reverse().toString();
        int answer = Integer.parseInt(s, 3);

        return answer;
    }
}
