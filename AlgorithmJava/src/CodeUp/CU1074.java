package CodeUp;

import java.io.*;
import java.util.*;

public class CU1074 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        long l = Long.parseLong(br.readLine());

        for(int i = (int)l; i >0;i--){
            System.out.println(i);
        }
        br.close();
    }
}
