import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int total = 0, twoCount = 0;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(st.nextToken());
            twoCount += target/2;
            total = total + target;
            arr[i] = target;
        }

        if(total % 3 != 0){
            System.out.println("NO");
            return;
        }

        int waterCount = total / 3;

        if(twoCount >= waterCount) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }
}
