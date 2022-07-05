package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1077 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        long s = Long.parseLong(br.readLine());

        for(int i = 0; i <= (int)s;i++){
            System.out.println(i);
        }
        br.close();
    }
}

