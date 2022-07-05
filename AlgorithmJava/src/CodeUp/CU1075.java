package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1075 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        long l = Long.parseLong(br.readLine());

        for(int i = (int)l; i >0;i--){
            System.out.println(i-1);
        }
        br.close();
    }
}
