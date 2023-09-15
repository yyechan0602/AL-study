import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //도시 분할 계획

    static class Edge implements Comparable<Edge>{
        int w;
        int cost;

        public Edge(int w, int cost){
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<Edge> pq;
    static boolean[] vis;
    static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        pq = new PriorityQueue<>();
        vis = new boolean[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[n1].add(new Edge(n2, cost));
            graph[n2].add(new Edge(n1, cost));
        }

        pq.offer(new Edge(1, 0));

        int res = 0, cnt = 0;
        int max = Integer.MIN_VALUE;

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            int tempNode = edge.w;
            int tempCost = edge.cost;

            if(vis[tempNode])
                continue;

            vis[tempNode] = true;

            res = res + tempCost;
            max = Math.max(max, tempCost);
            if(++cnt == n){
                break;
            }

            for(Edge eg : graph[tempNode]){
                if(!vis[eg.w]){
                    pq.add(eg);
                }
            }

        }

        System.out.println(res - max);

    }
}
