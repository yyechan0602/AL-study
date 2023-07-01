import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n5214 {
    //환승
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= N+M; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N+M+1];
        int[] distance = new int[N+M+1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < K; j++) {
                int temp = Integer.parseInt(st.nextToken());
                graph.get(temp).add(N+i+1);
                graph.get(N+i+1).add(temp);
            }
        }

        queue.offer(1);

        visited[1] = true;
        distance[1] = 1;

        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to: graph.get(from)) {
                if (visited[to]) continue;
                visited[to] = true;
                distance[to] = distance[from]+1;
                queue.offer(to);
            }
        }

        if(visited[N])
            System.out.println(distance[N]/2 + 1);
        else
            System.out.println(-1);

    }

}