package TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n7453 {
    //합이 0인 네 정수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[4][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);
        Arrays.sort(arr[2]);
        Arrays.sort(arr[3]);

        long[][] sumTwoArr = new long[2][n*n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumTwoArr[0][n*i + j] = arr[0][i] + arr[1][j];
                sumTwoArr[1][n*i + j] = arr[2][i] + arr[3][j];
            }
        }

        Arrays.sort(sumTwoArr[0]);
        Arrays.sort(sumTwoArr[1]);

        int highIndex = 0;
        int lowIndex = n * n-1;
        long cnt = 0;

        while (highIndex < n * n && lowIndex >= 0) {
            if (sumTwoArr[0][highIndex] + sumTwoArr[1][lowIndex] > 0) {
                lowIndex--;
            } else if (sumTwoArr[0][highIndex] + sumTwoArr[1][lowIndex] < 0) {
                highIndex++;
            }else{
                long highCnt = 1;
                long lowCnt = 1;

                while(highIndex != n*n - 1 ){

                    if(sumTwoArr[0][highIndex] == sumTwoArr[0][highIndex + 1]){
                        highCnt++;
                        highIndex++;
                    }else
                        break;

                }

                while(lowIndex != 0){
                    if(sumTwoArr[1][lowIndex] == sumTwoArr[1][lowIndex -1]){
                        lowIndex--;
                        lowCnt++;
                    }else
                        break;
                }

                highIndex++;
                cnt = cnt + highCnt * lowCnt;
            }
        }

        System.out.println(cnt);
    }
}