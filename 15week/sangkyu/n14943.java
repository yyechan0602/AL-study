import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];

        long bug = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            bug += arr[i];
            sum += Math.abs(bug);
        }

        System.out.println(sum);
    }
}
