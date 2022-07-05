package CodeUp;

import java.io.*;
import java.util.*;

public class CU1048 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final long[] arr = new long[st.countTokens()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(arr[0] << arr[1]);


        br.close();
    }
}
