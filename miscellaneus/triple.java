import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String tStr = next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = nextInt();
            int q = nextInt();

            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = nextInt();
            }

            int[] pref0 = new int[n + 1];
            int[] prefAdj = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                pref0[i] = pref0[i - 1] + (a[i] == 0 ? 1 : 0);
                if (i < n) {
                    prefAdj[i] = prefAdj[i - 1] + (a[i] == a[i + 1] ? 1 : 0);
                }
            }

            for (int i = 0; i < q; i++) {
                int l = nextInt();
                int r = nextInt();

                int len = r - l + 1;
                if (len % 3 != 0) {
                    out.println("-1");
                    continue;
                }

                int count0 = pref0[r] - pref0[l - 1];
                if (count0 % 3 != 0) {
                    out.println("-1");
                    continue;
                }

                int adjCount = prefAdj[r - 1] - prefAdj[l - 1];
                if (adjCount > 0) {
                    out.println(len / 3);
                } else {
                    out.println(len / 3 + 1);
                }
            }
        }
        out.flush();
    }
}