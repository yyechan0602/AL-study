import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        long res = 0;
        Set<Integer> num = new HashSet<>();

        for(int i=0;i<n;i++){

            if(num.contains(arr[i])){
                for(int j=start;j<i;j++){
                    res = res + i-j;
                    start++;

                    if(arr[j] == arr[i])
                        break;

                    num.remove(arr[j]);
                }
                continue;
            }

            num.add(arr[i]);
        }

        for(int i=start;i<n;i++)
            res = res + n-i;

        System.out.println(res);
    }
}
