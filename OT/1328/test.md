## 문제설명

- 문제 : 백준 1328, 고층빌딩.
- 난이도 : Platinum 5
- 알고리즘 : Dynamic Programming
- 왼쪽에서 봤을 때 보이는 빌딩 수와 오른쪽에서 봤을 때 보이는 빌딩의 수로 가능한 경우의 수 찾기.

## 주의사항
- 문제의 출력 조건에 '경우의 수를 1,000,000,007로 나눈 나머지를 출력하라.' 라는 문구가 있으므로 자료형에 주의한다.

## 접근 방법
- Dynamic Programin 의 bottom-up 방식으로 접근.
- N의 조건이 1 ≤ N ≤ 100이므로 직접 경우의 수를 따져보았다.
- 확신을 가지게 된 부분은 N = 3일 때, 가능한 빌딩의 배치는 총 6가지다.
  - (1,2,3), (1,3,2), (2,1,3), (2,3,1), (3,1,2), (3,2,1)
- 여기서 각 빌딩의 높이를 1씩 올려주어도 경우의 수는 그대로이다.
  - (2,3,4), (2,4,3), (3,2,4), (3,4,2), (4,2,3), (4,3,2)
- 그러므로 N = 4인 경우를 구하려면 높이가 1인 빌딩을 숫자 사이에 끼워 넣으면 된다.
  - 높이가 1인 빌딩을 가장 왼쪽에 놓을 시 : 왼쪽에서 보이는 값 +1
  - 높이가 1인 빌을 가장 오른쪽에 놓을 시 : 오른쪽에서 보이는 값 +1
  - 높이가 1인 빌딩을 가운데 놓을 시 : 영향 없음.
- 그러므로 양 옆에 놓는 수를 빼면 (전체 경우의 수 - 2)임을 알 수 있다.
- DP 배열 선언 : 3차원 배열로 선언하며, 각 항목별로 (최대 높이, 왼쪽에서 보이는 건물 수, 오른쪽에서 보이는 건물 수) 로 선언한다.
- 위의 빨간색 부분을 점화식으로 옮기면,
  - DP[n][l][r] = DP[n-1][l-1][r] + DP[n-1][l][r-1] + DP[n-1][l][r] * (n-2) 이다.
- 입력 범위에 맞게 DP배열을 완성하고 출력한다.

## 소스 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] DP = new long[101][101][101];

        DP[1][1][1] = 1;
        for(int i=2; i<=N; i++){
            for(int j=1; j<=L; j++){
                for(int k=1; k<=R; k++){
                    DP[i][j][k] += DP[i-1][j][k]*(i-2);
                    DP[i][j][k] += DP[i-1][j-1][k];
                    DP[i][j][k] += DP[i-1][j][k-1];
                    DP[i][j][k] %= 1000000007;
                }
            }
        }
        
        System.out.println(DP[N][L][R]);
    }
}
```
