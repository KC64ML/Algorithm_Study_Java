package CodeUp;

import java.io.*;
import java.util.*;

public class CU1051 {
    public static void main(String[] args) throws IOException{
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final long[] arr = new long[st.countTokens()];

        for(int i =0;i<arr.length;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        if(arr[0] <= arr[1]){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

        br.close();
    }
}
