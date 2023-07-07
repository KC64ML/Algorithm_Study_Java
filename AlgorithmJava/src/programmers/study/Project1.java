package programmers.study;


import java.io.IOException;
import java.util.*;

public class Project1 {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        int[] arr = list.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
    }
}
