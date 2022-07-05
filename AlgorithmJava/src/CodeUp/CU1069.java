package CodeUp;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CU1069 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        List<String> list = new ArrayList<>();

        switch(br.readLine()){
            case "A":
                list.add("best!!!");
                break;
            case "B":
                list.add("good!!");
                break;
            case "C":
                list.add("run!");
                break;
            case "D":
                list.add("slowly~");
                break;
            default:
                list.add("what?");
                break;
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

