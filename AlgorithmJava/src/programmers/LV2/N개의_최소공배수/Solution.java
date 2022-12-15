import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;

        Arrays.sort(arr);


        // 2부터 시작하여 가장 큰 데이터에 도착했다면 종료
        int startData = 2;
        int len = arr[arr.length - 1];

        while (startData <= len) {

            // System.out.println("Start Data :  " + startData);

            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % startData == 0) cnt += 1;
            }


            // 만약 두 수의 배수라면, 현재 구간의 최소 공배수를 구한다.
            if (cnt >= 2) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] % startData == 0) {
                        arr[i] /= startData;
                    }
                }
                answer *= startData;
            } else {
                startData += 1;
            }

            // System.out.println("arr : " + Arrays.toString(arr));

        }

        for (int in_arr : arr) {
            answer *= in_arr;
        }

        return answer;
    }
}