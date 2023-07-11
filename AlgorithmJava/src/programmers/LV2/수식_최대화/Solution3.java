package programmers.LV2.수식_최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(1);
        list.add(1);

        System.out.println(Arrays.toString(list.toArray()));
    }
}
