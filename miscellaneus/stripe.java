import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        StringBuilder res = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine().trim();
            
            int cur = 0;
            for (int i = 0; i < k; i++) {
                if (s.charAt(i) == 'W') cur++;
            }
            
            int minVal = cur;
            for (int i = k; i < n; i++) {
                if (s.charAt(i - k) == 'W') cur--;
                if (s.charAt(i) == 'W') cur++;
                if (cur < minVal) minVal = cur;
            }
            res.append(minVal).append("\n");
        }
        System.out.print(res);
    }
}