package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1080 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        long s = Long.parseLong(br.readLine());
        int sum = 0;
        int answer = 0;
        for(int i = 1; i <= (int)s;i++){
            if(sum < s){
                sum += i;
                answer = i;
            }else{
                break;
            }

        }
        System.out.println(answer);
        br.close();
    }
}

