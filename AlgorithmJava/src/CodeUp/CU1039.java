package CodeUp;

import java.io.*;
import java.util.*;

public class CU1039 {
    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());

        final long[] arr = new long[st.countTokens()];
        long result = 0;
        for(int i =0; i<arr.length;i++){
            result += Long.parseLong(st.nextToken());
        }

        System.out.println(result);

        br.close();
    }
}
