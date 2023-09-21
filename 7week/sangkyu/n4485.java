### **전체** **코드**

```java
import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};
    static boolean vis[][];
    static int map[][];
    static int cost[][];
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) {
                break;
            }

            map = new int[N][N];
            vis = new boolean[N][N];
            cost= new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE;
                }
            }

            BFS();

            sb.append("Problem ").append(cnt).append(": ").append(cost[N - 1][N - 1]).append('\n');
            cnt++;
        }

        System.out.println(sb);

    }

    private static void BFS() {
        PriorityQueue<Node> que = new PriorityQueue<>();

        vis[0][0] = true;

        que.offer(new Node(0, 0, map[0][0]));

        while( !que.isEmpty() ) {

            Node cur = que.poll();

            for(int i=0; i<4; i++) {
                int nextR = cur.row + dr[i];
                int nextC = cur.col + dc[i];

                if(nextR < 0 || nextC < 0 || nextR >= N || nextC >= N)
                    continue;

                if(vis[nextR][nextC])
                    continue;

                if(cost[nextR][nextC] <= map[nextR][nextC] + cur.cost)
                    continue;

                cost[nextR][nextC] = map[nextR][nextC] + cur.cost;
                vis[nextR][nextC] = true;

                que.offer( new Node(nextR, nextC, cost[nextR][nextC] ));
            }
        }

    }
}
```
