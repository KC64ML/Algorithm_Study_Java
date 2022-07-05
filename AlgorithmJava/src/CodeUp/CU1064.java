package CodeUp;

import java.io.*;
import java.util.StringTokenizer;

public class CU1064 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final long[] arr = new long[st.countTokens()];

        for(int i=0;i<arr.length;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long min_data = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(min_data > arr[i])
                min_data = arr[i];
        }

        System.out.println(min_data);

        br.close();
    }
}
