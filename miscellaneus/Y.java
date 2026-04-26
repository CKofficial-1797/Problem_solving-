import java.io.*;
import java.util.*;

class Codechef {
    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        public Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null) return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    return null;
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
        Scanner sc = new Scanner();
        String tStr = sc.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            int m = sc.nextInt();
            long s = 0;
            for (int i = 0; i < m; i++) {
                long val = sc.nextLong();
                if (val > 0) s += val;
            }

            long ms = 0, cs = 0;
            long mp = 0, cp = 0;
            
            for (int i = 0; i < n; i++) {
                cs += a[i];
                if (cs < 0) cs = 0;
                if (cs > ms) ms = cs;

                cp += a[i];
                if (cp > mp) mp = cp;
            }

            long msuff = 0, csuff = 0;
            for (int i = n - 1; i >= 0; i--) {
                csuff += a[i];
                if (csuff > msuff) msuff = csuff;
            }

            long ans = ms;
            if (s + mp > ans) ans = s + mp;
            if (s + msuff > ans) ans = s + msuff;

            System.out.println(ans);
        }
    }
}