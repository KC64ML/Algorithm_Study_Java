package programmers.Lv1.문자열내_py_개수_효율;

public class Solution2 {
    boolean solution(String s) {
        boolean answer = true;

        int pCnt = 0;
        int yCnt = 0;

        for(char c : s.toCharArray()){
            if(Character.toUpperCase(c) == 'P') pCnt += 1;
            else if(Character.toUpperCase(c) == 'Y') yCnt += 1;
        }

        return pCnt == yCnt;
    }
}
