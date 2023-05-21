import java.io.*;
import java.util.*;
public class Main {
    static int l = 0; // L
    static int c = 0; // C
    static char[] arr = new char[16]; // C개의 알파벳 배열
    static char[] result = new char[16]; // 결과 배열
    static boolean[] visit = new boolean[16]; // 백트랙킹에 사용할 방문 배열
    static char[] moum = {'a','e','i','o','u'}; // 모음 배열

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        l= Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<c;i++)
        {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr,0,c); // 정렬 ( 오름차순의 결과를 위해 )
        travel(0,0,0); // 백트랙킹

        bw.flush();
        bw.close();
        br.close();
    }

    static void travel(int k,int m, int g) throws IOException
    {
        // L길이에 도달하고 모음과 자음의 개수가 일치할 때
        if(k==l&&m>=1&&g>=2)
        {
            for(int i=1;i<=l;i++)
            {
                bw.write(result[i]);
            }bw.write("\n");
            return;
        }

        for(int i=0;i<c;i++)
        {
            if(!visit[i]&&result[k]<arr[i])
            {
                result[k+1] = arr[i];
                visit[i]= true;
                if(isMoum(arr[i])) {
                    travel(k + 1,m+1,g);
                }
                else{
                    travel(k+1,m,g+1);
                }
                visit[i] = false;
            }
        }

    }
    // 해당 알파벳이 모음인지 자음인지 확인하는 함수
    static boolean isMoum(char c)
    {
        for(int i=0;i<5;i++)
        {
            if(c==moum[i])
                return true;
        }
        return false;
    }
}
