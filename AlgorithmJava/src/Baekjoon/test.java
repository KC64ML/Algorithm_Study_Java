package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        l.stream().map( i -> i * i).forEach(System.out::println);

        Arrays.asList(Arrays.asList(1,2,3,4,5)
                        .stream()
                        .reduce((a, b)-> a-b)  // 1 - 2 = -1-3 = -4-4 = -8-5 = -13
                        .get())
                .forEach(System.out::println);

    }
}
