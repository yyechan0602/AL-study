import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //사과와 바나나
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[][] map = new String[r+2][c+2];
        int[][] apple = new int[r+2][c+2];
        int[][] banana = new int[r+2][c+2];
        int[][] dp = new int[r+2][c+2];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= c; j++) {

                map[i][j] = st.nextToken();

                if(map[i][j].charAt(0) == 'B'){
                    banana[i][j] = Integer.parseInt(map[i][j].replace("B",""));
                }else{
                    apple[i][j] = Integer.parseInt(map[i][j].replace("A",""));
                }
            }

        }


        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                apple[i][j] += apple[i][j-1];
                banana[i][c-j+1] += banana[i][c-j+2];
            }
        }

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = dp[i-1][j] + banana[i][j+1];
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + apple[i][j-1] + banana[i][j+1];
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1] - banana[i][j] + banana[i][j+1]);
            }
        }

        System.out.println(dp[r][c]);
    }
}
