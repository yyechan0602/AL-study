package BOJ.Making;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2533 {
    private static class friend implements Comparable<friend> {
        int first;
        int second;

        public friend(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(friend o) {
            if (this.first < o.first) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[N+1];
        friend[] friends = new friend[N-1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            friends[i] = new friend(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(friends);

        for (int i = 0; i < N-1; i++) {
            dp[friends[i].second] = !dp[friends[i].first];
        }

        int count = 0;

        for (int i = 1; i < N+1; i++) {
            if(dp[i]) count++;
        }

        System.out.println(Math.min(count, N-count));
    }
}
