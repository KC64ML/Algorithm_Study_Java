package programmers.Lv1.문자열_내림차순_정렬;

class Solution {
    public String solution(String s) {

        // String 안에 있는 char형으로
        // char형을 Integer형으로 Stream<Integer>
        return s.chars()
                .boxed()
                .sorted((c1, c2) -> (c2 - c1))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
    }
}