import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            int front = 0;
            int back = N - 1;

            while (front != back) {
                if (front == i && front < back) {
                    front++;
                    continue;
                } else if (back == i && front < back) {
                    back--;
                    continue;
                }

                if (nums[front] + nums[back] > nums[i]) {
                    back--;
                } else if (nums[front] + nums[back] < nums[i]) {
                    front++;
                } else {
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
