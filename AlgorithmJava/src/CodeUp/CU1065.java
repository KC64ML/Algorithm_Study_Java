package CodeUp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CU1065 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final long[] arr = new long[st.countTokens()];

        for(int i=0;i<arr.length;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }


        List<Long> list = new ArrayList<>();

        for(int i =0;i<arr.length;i++){
            if(arr[i] % 2 == 0){
                list.add(arr[i]);
            }
        }

        for(int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        br.close();
    }
}
