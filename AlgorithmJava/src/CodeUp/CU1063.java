package CodeUp;

import java.io.*;
import java.util.StringTokenizer;

public class CU1063 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final long[] arr = new long[st.countTokens()];

        for(int i=0;i<arr.length;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long max_data = 0;

        for(int i=0;i<arr.length;i++){
            if(max_data < arr[i])
                max_data = arr[i];
        }

        System.out.println(max_data);

        br.close();
    }
}
