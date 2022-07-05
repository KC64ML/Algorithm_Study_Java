package CodeUp;

import java.io.*;

public class CU1041 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char r;
        if(s.charAt(0) == 'z'){
            r = 'a';
        }else{
            r = (char)((int)s.charAt(0) + 1);
        }

        System.out.println(r);
        br.close();
    }
}
