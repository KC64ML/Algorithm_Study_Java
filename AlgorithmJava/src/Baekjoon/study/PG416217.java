package Baekjoon.study;

import java.util.Arrays;

public class PG416217 {
    static String[][] infoStr;
    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};
//        infoStr = new String[info.length][5];
//        for(int i = 0; i< info.length; i++){
//            String[] s = info[i].split(" ");
//            infoStr[i] = s;
//        }
//
//        for(int i = 0; i < query.length;i++){
//            String[] s = query[i].split(" ");
//            for(int k = 0; k < infoStr.length; k++){
//                for(int z = 0 ; z < 5; z++){
//                    if(s[z])
//                        if(infoStr[k][z] != )
//                }
//            }
//            for(int j = 0; j < s.length; j++){
//                if(s[j] != "and"){
//
//                }
//            }
//        }

        return answer;
    }

    public static void main(String[] args) {

        String[] s = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] s2 = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        solution(s, s2);
    }
}
