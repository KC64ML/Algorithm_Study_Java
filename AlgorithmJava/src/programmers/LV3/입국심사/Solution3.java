package programmers.LV3.입국심사;

public class Solution3 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 5, 7, 9, 11};
        int target = 5;

        int start = 0;
        int end = arr.length;
        int answer = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            if(arr[mid] == 5){
                answer = mid;
                break;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(answer);
        
    }
}
