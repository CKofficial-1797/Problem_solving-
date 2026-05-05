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

        long nextLong() {
            return Long.parseLong(next());
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
            long k = fs.nextLong();
            long limit = k + 1;

            long[] qArr = new long[n];
            for (int i = 0; i < n; i++) {
                qArr[i] = fs.nextLong() + 1;
            }

            long[] rArr = new long[n];
            for (int i = 0; i < n; i++) {
                rArr[i] = fs.nextLong() + 1;
            }

            Arrays.sort(qArr);
            Arrays.sort(rArr);

            int lb = 0;
            int rb = n;
            int ans = 0;

            while (lb <= rb) {
                int sz = lb + (rb - lb) / 2;
                boolean canForm = true;

                for (int i = 0; i < sz; i++) {
                    if (qArr[i] * rArr[sz - 1 - i] > limit) {
                        canForm = false;
                        break;
                    }
                }

                if (canForm) {
                    ans = sz;
                    lb = sz + 1;
                } else {
                    rb = sz - 1;
                }
            }

            out.println(ans);
        }
        
        out.flush();
    }
}