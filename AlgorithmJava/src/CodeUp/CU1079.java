package CodeUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CU1079 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        String s = br.readLine();
        String[] list_s = s.split(" ");

        for(int i =0 ;i<list_s.length;i++){
            if(list_s[i].equals("q")){
                System.out.println("q");
                break;
            }else{
                System.out.println(list_s[i]);
            }
        }

        br.close();
    }
}

