import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int base = r / (b + 1);
            int rem = r % (b + 1);
            
            for (int i = 0; i <= b; i++) {
                int c = base + (rem > 0 ? 1 : 0);
                rem--;
                
                for (int j = 0; j < c; j++) {
                    out.append('R');
                }
                if (i < b) {
                    out.append('B');
                }
            }
            out.append("\n");
        }
        
        System.out.print(out);
    }
}