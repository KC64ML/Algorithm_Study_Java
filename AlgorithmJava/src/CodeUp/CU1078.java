package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1078 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        long s = Long.parseLong(br.readLine());
        int answer = 0;
        for(int i = 1; i <= (int)s;i++){
            if(i % 2 == 0){
                answer += i;
            }

        }
        System.out.println(answer);
        br.close();
    }
}

