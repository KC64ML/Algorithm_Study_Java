package Baekjoon.study;

import java.io.*;
import java.util.*;

class ProblemComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        for (int i = 0; i < o1.length; i++) {
            if (o1[i] > o2[i]) {
                return 1;
            } else if (o1[i] < o2[i]) {
                return -1;
            }
        }
        return 0;
    }
}

public class BJ1722 {

    static int N;
    static Integer[] arr;
    static int[] number;
    static ArrayList<int[]> arrayList;
    static boolean[] visited;


    static void prim(int cnt) {
        if (cnt == N) {
            int[] r = number.clone();
            arrayList.add(r);
            return;

        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                number[cnt] = (i + 1);
                prim(cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList<>();

        arr = new Integer[N];
        number = new int[N];
        visited = new boolean[N];


        prim(0);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());

        Collections.sort(arrayList, new ProblemComparator());
//        for (int[] ints : arrayList) {
//            System.out.println(Arrays.toString(ints));
//        }

        if (start == 1) {
            int number = Integer.parseInt(st.nextToken());
            for (int i : arrayList.get(number - 1)) {
                System.out.print(i + " ");
            }
        } else {
            int[] findArr = new int[N];
            int idx = 0;

            while (st.countTokens() > 0) {
                findArr[idx++] = Integer.parseInt(st.nextToken());
            }

            for (int tk = 0; tk < arrayList.size(); tk++) {
                if (Arrays.equals(arrayList.get(tk), findArr)) {
                    System.out.println(tk + 1);
                    break;
                }
            }
        }

        br.close();
    }
}
