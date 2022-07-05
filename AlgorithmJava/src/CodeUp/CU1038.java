package CodeUp;

import java.io.*;
import java.util.StringTokenizer;

public class CU1038 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열을 나눈다.

        // 정수로 치환
        final long[] nums = new long[st.countTokens()];

        for(int i=0 ; i<nums.length;i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(nums[0] + nums[1]);

        br.close();
    }
}
