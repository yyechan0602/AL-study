import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String b = br.readLine();

        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            st.push(c);
            
            if (st.size() >= b.length() && c == b.charAt(b.length() - 1)) {
                boolean found = true;
                for (int j = 0; j < b.length(); j++) {
                    if (st.get(st.size() - b.length() + j) != b.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                
                if (found) {

                    for (int j = 0; j < b.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();

        for (char c : st) {
            res.append(c);
        }

        if (res.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(res);

    }
}
