package CodeUp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CU1066 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final long[] arr = new long[st.countTokens()];

        List<String> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(Long.parseLong(st.nextToken()) % 2 == 0){
                list.add("even");
            }else{
                list.add("odd");
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
