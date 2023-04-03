package Baekjoon;

import java.util.*;

class Solution {


    static int[] bigDataList;
    static int[] smallDataList;
    static int[] checkSmallDataList;
    static int answer;

    public static int solution(int[] _dots, int[] _lines, int k) {
        Arrays.sort(_dots);
        Arrays.sort(_lines);

        if(_dots[0] > _lines[0]){
            bigDataList =  _dots;
            smallDataList = _lines;
        }else{
            bigDataList =  _lines;
            smallDataList = _dots;
        }

        int startData = 0;

        for(int i = 0 ; i <smallDataList.length; i++){
            if(smallDataList[smallDataList.length - 1] <= smallDataList[i] + k){
                startData = i;
                break;
            }
        }

        checkSmallDataList = new int[smallDataList.length];
        System.out.println("Start : " + startData);
        for(int i = 0; i < smallDataList.length; i++){
            System.out.println("i : " + i);
            if(i < startData){
                checkSmallDataList[i] = smallDataList[i + startData];
            }else{
                checkSmallDataList[i] = smallDataList[i - startData];
            }
        }
        for(int i : checkSmallDataList){
            System.out.print(i + " ");
        }

        // 0 ~ startData까지
        int bigIdx = 0;
        for(int i =startData ; i < checkSmallDataList.length; i++){
            answer += 1;

            while(bigIdx < bigDataList.length){
                if(smallDataList[i] > bigDataList[bigIdx]) break;
                else bigIdx++;
            }

            // 마지막 위치 전에 끝났다면
            if(bigIdx == bigDataList.length){
                if(i < (checkSmallDataList.length - 1)) answer += 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] dots = {1, 3, 5, 7};
        int[] lines = {2, 4, 6, 8};

        // 결과 2


        // 1 3 5 7
        // 2, 4, 6, 8
        // 결과 6
        System.out.println(solution(dots, lines, 2));
    }
}