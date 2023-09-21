import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class n1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] use = new int[K+1];
        int[] plug = new int[K+1];

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            plug[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int cnt = 0;

        for (int i = 0; i < K; i++) {
            int input = plug[i];

            if (use[input] != 0)//비었니 안비었니
                continue;
            else {
                if (cnt != N) {
                    use[input] = 1;
                    list.add(input);
                    cnt++;
                    continue;
                }
            }

            int index = 0, lastcnt = 0;

            for (int j = 0; j < N; j++) {//꽉찼구나
                int count = 0;

                for (int k = i + 1; k < K; k++) {
                    if (list.get(j) == plug[k])
                        break;
                    count++;
                }

                if (count > lastcnt) {//현재 뽑은애와 지금까지 뽑은애중에 누가 더 멀리있나
                    index = j;
                    lastcnt = count;
                }
            }

            use[list.get(index)] = 0;
            list.set(index, input);
            use[input] = 1;
            ans++;
        }

        System.out.println(ans);
    }
}
