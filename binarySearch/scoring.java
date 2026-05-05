import java.io.*;
import java.util.*;

public class Main {
    
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        
        String tStr = fs.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
        
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }
            
            int d = 1;
            for (int i = 0; i < n; i++) {
                if (i >= d && a[i - d] >= d + 1) {
                    d++;
                }
                out.print(d + " ");
            }
            out.println();
        }
        
        out.flush();
    }
}