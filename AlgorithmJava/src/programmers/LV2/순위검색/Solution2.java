package programmers.LV2.순위검색;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        String query = "John Doe and Jane Smith";
        String query2 = "John and Doe and Jane and Smith A";
        String[] tokens = query.split(" (and )?");
        String[] tokens2 = query2.split(" (and )?");
        System.out.println(Arrays.toString(tokens));
        System.out.println(Arrays.toString(tokens2));
    }
}
