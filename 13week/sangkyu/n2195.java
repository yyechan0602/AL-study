import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        int index = 0;
        int cnt = 1;
        
        for (int i = 0; i < p.length(); i++) {

            String temp = p.substring(index, i + 1);

            if (s.contains(temp)) {
                continue;
            }

            cnt++;
            index = i;
        }

        System.out.println(cnt);

    }
}
