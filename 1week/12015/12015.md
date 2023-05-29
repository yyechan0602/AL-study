[12015번: 가장 긴 증가하는 부분 수열 2](https://www.acmicpc.net/problem/12015)

- 가장 긴 증가하는 부분 수열 ( LIS )

### 입력

- 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
- 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000,000)

### 가장 긴 증가하는 부분 수열 1과 다른점

- 입력 단위가 크기 때문에 DP 방식으로는 **시간 초과 : O(N^2)**
- 이진 탐색을 활용한다면 : O(NlogN)

### 이진 탐색을 사용할 수 있는 이유

- 이진 탐색은 기본적으로 ‘정렬’이 이루어진 배열 , 리스트에 사용 가능
- **‘증가하는 부분 수열’**

```java
import java.io.*;
import java.util.*;
public class Main {
    static int n = 0;
    static int m = 0;
    static int[] board;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        board = new int[n];
        result = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++)
        {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int i = 1; // 입력 문자열 idx
        int j = 0; // 최장 길이 부분 수열 idx

        result[0] = board[0];

        while(i < n)
        {
            if(board[i] > result[j])
            {
                result[j+1] = board[i];
                j = j + 1;
            }

            else{
                int tmp = bs(0,j,board[i]);
                result[tmp] = board[i];
            }
            i = i + 1;
        }

        System.out.println(j+1);
        br.close();
    }
    static int bs(int left,int right,int target)
    {
        int mid = 0;
        while(left <= right)
        {
            mid = (left + right) / 2;

            if(result[mid] < target)
            {
                left = mid + 1;
            }

            else{
                right = mid -1 ;
            }
        }

        return left;
    }

}
```
