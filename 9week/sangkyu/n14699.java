import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class shelter implements Comparable<shelter> {
        int num;
        int height;

        shelter(int num, int height) {
            this.num = num;
            this.height = height;
        }

        @Override
        public int compareTo(shelter other) {
            return Integer.compare(other.height, this.height);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        shelter[] san = new shelter[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            san[i] = new shelter(i+1, height);
        }

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        Arrays.sort(san);

        int[] res = new int[n+1];

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int j = 0; j < graph.get(san[i].num).size(); j++) {
                max = Math.max(max, res[graph.get(san[i].num).get(j)]);
            }
            res[san[i].num] = max + 1;
        }

        for (int i = 1; i <= n ; i++) {
            sb.append(res[i]).append("\n");
        }

        System.out.print(sb);

    }
}
