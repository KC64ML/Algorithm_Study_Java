package programmers.Lv1.진법3_뒤집기;

class Solution {
    public int solution(int n) {

        StringBuilder builder = new StringBuilder();

        builder.append(Integer.toString(n, 3));
        String ternary = builder.reverse().toString();
        int answer = Integer.parseInt(ternary, 3);

        return answer;
    }
}
