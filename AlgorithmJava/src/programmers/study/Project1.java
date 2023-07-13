package programmers.study;


import java.io.IOException;
import java.util.*;

public class Project1 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        map.put("chang", 1);
        map.put("kyoung", 2);

// map -> set
        Set<String> set = map.keySet();
    }
}
