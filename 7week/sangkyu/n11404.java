import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11404 {
    //플로이드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j)
                    continue;

                if(map[i][j] != 0)
                    continue;

                map[i][j] = 1000000000;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(map[n1][n2] > cost)
                map[n1][n2] = cost;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j)
                    continue;
                for (int k = 1; k <= n ; k++) {
                    if(j ==k || i == k)
                        continue;

                    if(map[j][k] > map[j][i] + map[i][k])
                        map[j][k] = map[j][i] + map[i][k];
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(map[i][j] == 1000000000)
                    sb.append(0).append(" ");
                else
                    sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
