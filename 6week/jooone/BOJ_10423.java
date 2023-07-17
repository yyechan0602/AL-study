import java.io.*;
import java.util.*;

public class Main {
    static int n = 0;
    static int m = 0;
    static int k = 0;
    static int[] root;
    static boolean[] isCenter; // 발전기와 연결 여부

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        root = new int[n + 1];
        isCenter = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        } // make-> union -find

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= k; i++) {
            isCenter[Integer.parseInt(st.nextToken())] = true;
        } // 발전기인 노드 표시

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (x, y) -> x.v - y.v
        ); // 간선의 비용으로 우선순위 큐

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new Edge(x, y, v));
        }

        while (!pq.isEmpty()) {
            if (all())
                break; // 모든 노드가 발전기에 연결이 되었다면 탐색 종료

            Edge cur = pq.poll();

            if (find(cur.x) != find(cur.y)) {

                if (isCenter[root[cur.x]] && isCenter[root[cur.y]])
                    continue; // 둘 다 발전기에 연결이 되어 있다면 연결 불필요

                result += cur.v;
                union(cur.x, cur.y);
                cunion(cur.x, cur.y);
            }

        }

        System.out.println(result);
        br.close();
    }
    // 하나라도 발전기 배열이 false라면 false
    static boolean all() {
        for (int i = 1; i <= n; i++) {
            if (!isCenter[i])
                return false;
        }

        return true;
    }

    static int find(int x) {
        if (isCenter[x] || isCenter[root[x]]) {
            isCenter[x] = true;
            isCenter[root[x]] = true;
        }

        if (root[x] == x)
            return x;

        else
            return root[x] = find(root[x]);
    }

    static void cunion(int x, int y) {
        int nx = find(x);
        int ny = find(y);

        if (isCenter[nx] || isCenter[ny]) {
            isCenter[x] = true;
            isCenter[y] = true;
            isCenter[nx] = true;
            isCenter[ny] = true;
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y)
            root[y] = x;
        else
            root[x] = y;
    }
}

class Edge {
    int x; // 정점 1
    int y; // 정점 2
    int v; // cost

    Edge(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}
