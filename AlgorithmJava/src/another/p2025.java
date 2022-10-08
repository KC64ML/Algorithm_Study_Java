package another;

import java.util.*;

public class p2025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        for (String s : arr) {
            System.out.println(s);
        }

        sc.close();

    }
}
