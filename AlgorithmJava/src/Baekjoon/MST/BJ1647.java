package Baekjoon.MST;

import java.util.*;
import java.io.*;


public class BJ1647 {

    private static class Edge implements Comparable<Edge>{
        public final int house;
        public final int cost;

        Edge(int house, int cost){
            this.house = house;
            this.cost = cost;
        }

        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }

    private static int N, M;
    private static List<Edge>[] graph;


    private static ArrayList<Integer> prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        boolean[] visited = new boolean[N + 1];
        ArrayList<Integer> result = new ArrayList<>();

        while(pq.size() > 0){
            Edge edge = pq.poll();

            if(visited[edge.house]) continue;
            visited[edge.house] = true;

            // 현재 노드에서 다음 노드 비용 모두 저장
            result.add(edge.cost);

            for(Edge inEdge : graph[edge.house]){
                if(visited[inEdge.house]) continue;
                pq.offer(inEdge);
            }
        }

        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[N + 1];

        for(int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();

        for(int i = 0 ; i < M; i++){
            tokenizer = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int cost = Integer.parseInt(tokenizer.nextToken());

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        ArrayList<Integer> list = prim();
        Collections.sort(list);

        int answer = 0;
        for(int i = 0; i < list.size() - 1; i++){
            answer += list.get(i);
        }

        System.out.println(answer);

        reader.close();
    }
}
