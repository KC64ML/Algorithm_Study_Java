package programmers.Lv1.숫자_문자열과_영단어;

public class Solution2 {

    private String[] numbers = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
    };

    public int solution(String s) {
        for(int i = 0; i < 10; i++){
            s = s.replace(numbers[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
