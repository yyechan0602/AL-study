import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int n;
        int m;
        int arr[][];
        int dp[][];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            arr = new int[n + 1][m + 1];
            dp = new int[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = arr[i][j];
                }
            }

            int res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (arr[i][j] == 1) {
                        int len = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = len;
                        if (arr[i - len][j - len] == 1) dp[i][j]++;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }

            out.println(res);
        }
    }
}
