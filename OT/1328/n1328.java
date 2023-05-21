package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1328 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] DP = new long[101][101][101];
        DP[1][1][1] = 1;
        for(int i=2; i<=N; i++){
            for(int j=1; j<=L; j++){
                for(int k=1; k<=R; k++){
                    DP[i][j][k] += DP[i-1][j][k]*(i-2);
                    DP[i][j][k] += DP[i-1][j-1][k];
                    DP[i][j][k] += DP[i-1][j][k-1];
                    DP[i][j][k] %= 1000000007;
                }
            }
        }

        System.out.println(DP[N][L][R]);
    }
}
