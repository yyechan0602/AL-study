import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class n17779 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    for (int l = 1; l <= N; l++) {
                        if (i + k + l <= N && 1 <= j - k && j + l <= N) {
                            result = Math.min(result, calculatePopulation(i, j, k, l));
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    static int calculatePopulation(int x, int y, int r, int c) {
        int[] arr = new int[6];

        int[][] board = new int[N+1][N+1];
				//왼위, 오아래
        for (int i = 0; i <= r; i++) {
            board[x+i][y-i] = 5;
            board[x+c+i][y+c-i] = 5;
        }

				//오위, 왼아래
        for (int i = 0; i <= c; i++) {
            board[x+i][y+i] = 5;
            board[x+r+i][y-r+i] = 5;
        }

				//나머지 중앙
        for (int i = 1; i <= N; i++) {
            int start = 0, end = 0;

            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 5) {
                    if (start == 0)
                        start = j;
                    else
                        end = j;
                }

                if (start != 0 && end != 0) {
                    for (int k = start; k <= end; k++) {
                        board[i][k] = 5;
                    }
                    start = end = 0;
                }
            }
        }

        // 1
        for (int i = 1; i < x + r; i++) {
            for (int j = 1; j <= y; j++) {
                if (board[i][j] == 5)
                    break;
                arr[1] += map[i][j];
            }
        }

        // 2
        for (int i = 1; i <= x + c; i++) {
            for (int j = N; j > y; j--) {
                if (board[i][j] == 5)
                    break;
                arr[2] += map[i][j];
            }
        }

        // 3
        for (int i = x + r; i <= N; i++) {
            for (int j = 1; j < y - r + c; j++) {
                if (board[i][j] == 5)
                    break;
                arr[3] += map[i][j];
            }
        }

        // 4
        for (int i = x + c + 1; i <= N; i++) {
            for (int j = N; j >= y - r + c; j--) {
                if (board[i][j] == 5)
                    break;
                arr[4] += map[i][j];
            }
        }
				//5
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] == 5) {
                    arr[5] += map[i][j];
                }
            }
        }


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= 5; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return max - min;
    }
}
