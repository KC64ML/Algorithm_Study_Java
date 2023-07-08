package programmers.Lv1.자연수_뒤집어_배열로_만들기;

public class Solution {
    public int[] solution(long n) {

        String s = Long.toString(n);
        StringBuilder builder = new StringBuilder().append(s).reverse();
        char[] arr = builder.toString().toCharArray();

        int[] result = new int[arr.length];
        for(int i =0 ; i < arr.length; i++){
            result[i] = arr[i] - '0';
        }

        return result;
    }
}
