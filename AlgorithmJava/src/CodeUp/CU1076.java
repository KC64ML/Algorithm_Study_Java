package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1076 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        String s = br.readLine();

        for(int i = 'a'; i <= s.charAt(0);i++){
            System.out.print((char)i + " ");
        }
        br.close();
    }
}

