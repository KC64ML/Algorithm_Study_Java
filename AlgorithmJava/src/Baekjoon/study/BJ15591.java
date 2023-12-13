package Baekjoon.study;

import java.util.*;
import java.io.*;

public class BJ15591 {
    private static class Node{
        public final int nextNode;
        public final int cost;

        Node(int nextNode, int cost){
            this.nextNode = nextNode;
            this.cost = cost;
        }
    }

    private static int N, Q;
    private static ArrayList<Node> nextNode[];

    private static int bfs(int k, int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        boolean[] visited = new boolean[N];
        visited[v] = true;
        int cnt = 0;

        while(queue.size() > 0){
            int nextIndex = queue.poll();

            for(Node node : nextNode[nextIndex]){
                int curCost = node.cost;
                int curNode = node.nextNode;

                if(visited[curNode]) continue;
                if(curCost < k) continue;
                visited[curNode] = true;
                cnt += 1;
                queue.add(curNode);
            }
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        Q = Integer.parseInt(tokenizer.nextToken());

        nextNode = new ArrayList[N];

        for(int i = 0; i < N; i++){
            nextNode[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());

            nextNode[a].add(new Node(b, c));
            nextNode[b].add(new Node(a, c));
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < Q; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int k = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken()) - 1;

            int cnt = bfs(k, v);
            builder.append(cnt).append("\n");
        }

        System.out.print(builder.toString());

        reader.close();
    }
}
