import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    //내일 할거야
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            arr[i][0] = v2;
            arr[i][1] = v1;
        }

        Arrays.sort(arr, (o1, o2) -> {
            return o2[0] - o1[0];
        });

        int res = arr[0][0];

        for(int i=0; i<n; ++i){
            if(arr[i][0] <= res){
                res = arr[i][0] - arr[i][1];
            }
            else{
                res -= arr[i][1];
            }
        }

        System.out.print(res);
    }
}
