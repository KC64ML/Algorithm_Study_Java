package CodeUp;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CU1068 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long l = Long.parseLong(br.readLine());

        List<String> list = new ArrayList<>();

        if( l >= 90){
            list.add("A");
        }else if(l >= 70){
            list.add("B");
        }else if(l >= 40){
            list.add("C");
        }else {
            list.add("D");
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

