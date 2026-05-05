import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
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
            char[] s = fs.next().toCharArray();

            boolean possible = true;
            int i = 0;
            
            while (i < n) {
                if (s[i] == '0') {
                    int j = i;
                    while (j < n && s[j] == '0') {
                        j++;
                    }
                    if (j - i == 1) {
                        possible = false;
                        break;
                    }
                    i = j;
                } else {
                    i++;
                }
            }

            if (!possible) {
                out.println("NO");
                continue;
            }

            out.println("YES");
            int[] p = new int[n];
            i = 0;
            
            while (i < n) {
                if (s[i] == '1') {
                    p[i] = i + 1;
                    i++;
                } else {
                    int j = i;
                    while (j < n && s[j] == '0') {
                        j++;
                    }
                    for (int k = i; k < j - 1; k++) {
                        p[k] = k + 2;
                    }
                    p[j - 1] = i + 1;
                    i = j;
                }
            }

            for (int k = 0; k < n; k++) {
                out.print(p[k] + " ");
            }
            out.println();
        }
        
        out.flush();
    }
}