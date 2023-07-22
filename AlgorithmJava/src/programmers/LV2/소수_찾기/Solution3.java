package programmers.LV2.소수_찾기;

import java.util.*;

public class Solution3 {

    // 소수
    private static boolean primeNumber(int number){
        if(number % 2 == 0) return false;

        for(int i = 3; i * i <= number; i++){
            if(number % i == 0) return false;
        }

        return true;
    }

    private static int[] numberArr;
    private static Set<Integer> set;
    private static boolean[] visited;
    private static boolean[] primeArr;

    // 순열
    private static void permutation(int cnt, int r, int[] arr){
        if(cnt == r){
            System.out.println(Arrays.toString(arr));
            for(int inArr : arr) set.add(inArr);
            return;
        }else{
            for(int i = 0 ; i < numberArr.length; i++){
                if(visited[i]) continue;
                if(cnt > 0) arr[cnt] = arr[cnt - 1] * 10 + numberArr[i];
                else arr[cnt] = numberArr[i];

                visited[i] = true;

                permutation(cnt + 1, r, arr);

                arr[cnt] = 0;
                visited[i] = false;

            }
        }
    }

    public static int solution(String numbers) {

        numberArr = numbers.chars().map((n) -> n - '0').toArray();
        primeArr = new boolean[(int)Math.pow(10, numbers.length() + 1)];
        visited = new boolean[numberArr.length + 1];
        set = new HashSet<>();

        for(int i = 2; i < (int)Math.pow(10, numbers.length()) + 1; i++) primeArr[i] = primeNumber(i);
        // 모든 경우의 수를 통해 확인한다.
        // nCr
        for(int r = 1; r <= numberArr.length; r++){

            // 방문 초기화
            Arrays.fill(visited, false);
            permutation(0, r, new int[r]);
        }

        int answer = 0;
        // 소수를 확인한다.
        for(int inNumber : set){
            answer += (primeArr[inNumber] ? 1 : 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "011";
        int answer = solution(s);
        System.out.println(answer);
    }
}
