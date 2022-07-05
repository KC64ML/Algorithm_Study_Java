package CodeUp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CU1067 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long l = Long.parseLong(br.readLine());

        List<String> list = new ArrayList<>();

        if(l < 0){
            list.add("minus");
        }else{
            list.add("plus");
        }

        if(l % 2 == 0){
            list.add("even");
        }else{
            list.add("odd");
        }


        for (String s : list) {
            System.out.println(s);
        }
    }
}
