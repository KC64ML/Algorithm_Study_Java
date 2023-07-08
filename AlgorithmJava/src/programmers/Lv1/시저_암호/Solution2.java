package programmers.Lv1.시저_암호;

class Solution2 {
    public String solution(String s, int n) {
        char[] c = s.toCharArray();

        int interstitialSpace = 'Z' - 'A' + 1;

        StringBuilder builder = new StringBuilder();
        for(char inC : c){
            if(!Character.isAlphabetic(inC)){
                builder.append(" ");
                continue;
            }

            char nextC = ' ';
            if('A' <= inC && inC <= 'Z'){
                nextC = (char)(((inC + n) - 'A') % interstitialSpace + 'A');
            }else if('a' <= inC && inC <= 'z'){
                nextC = (char)(((inC + n) - 'a') % interstitialSpace + 'a');
            }

            builder.append(nextC);
        }

        return builder.toString();
    }
}
