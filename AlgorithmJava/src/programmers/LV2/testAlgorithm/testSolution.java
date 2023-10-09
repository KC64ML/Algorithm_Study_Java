package programmers.LV2.testAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class testSolution {
    public static void main(String[] args) {
        String[] s = {"Abse", "Asee", "eee", "avsd"};
        String test = "Abs";

        List<String> list = Arrays.stream(s).map(c -> c.replaceAll("[^" + s[2] +"]", "")).filter(s[2]::startsWith).collect(Collectors.toList());
        System.out.println(Arrays.asList(list));
        int[] size = {3, 4, 5};
    }
}
