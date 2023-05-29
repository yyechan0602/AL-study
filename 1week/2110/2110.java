import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 도현집
        int C = Integer.parseInt(input[1]); // 공유기 수
        int[] houses = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(houses);

        int left = 1; // 가능한 최소 간격
        int right = houses[N - 1] - houses[0]; // 가능한 최대 간격
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1; // 공유기 설치 개수
            int idxHouse = houses[0];

            for (int i = 1; i < N; i++) {
                int distance = houses[i] - idxHouse;
                if (distance >= mid) {
                    count++;
                    idxHouse = houses[i];
                }
            }

            if (count >= C) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}