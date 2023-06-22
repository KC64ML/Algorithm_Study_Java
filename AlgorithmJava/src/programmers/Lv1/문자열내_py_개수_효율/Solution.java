package programmers.Lv1.문자열내_py_개수_효율;

public class Solution {
    boolean solution(String s) {

        // 직접 순회 코드
//        int ps = 0;
//        int ys = 0;
//
//        for(char c : s.toCharArray()){
//            switch(c) {
//                case 'p', 'P' -> ps++;
//                case 'y', 'Y' -> ys++;
//            }
//        }
//
//        return ps == ys;


        // 내장 라이브러리를 이용한 코드
        s = s.toLowerCase();
        int ps = s.length() - s.replace("p", "").length();
        int ys = s.length() - s.replace("y", "").length();
        return ps == ys;



    }
}
