package programmers.LV2.타겟넘버;

public class Solution2 {

    private int answer;

    private void dfs(int index, int sum, int target, int[] numbers){


        if(index == numbers.length){
            if(sum == target){
                answer += 1;
                // System.out.println("index : " + index + " sum : " + sum);
            }
            return;
        }

        dfs(index + 1, sum - numbers[index], target, numbers);
        dfs(index + 1, sum + numbers[index], target, numbers);
    }

    public int solution(int[] numbers, int target) {
        // idx, sum, target
        dfs(0, 0, target, numbers);

        return answer;
    }
}
