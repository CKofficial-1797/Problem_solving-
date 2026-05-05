import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            long[] b = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }

            byte[] s = new byte[k];
            int sIdx = 0;
            int ch = sc.read();
            while (ch <= 32 && ch != -1) ch = sc.read();
            while (ch > 32) {
                s[sIdx++] = (byte) ch;
                ch = sc.read();
            }

            Arrays.sort(b);

            long[] eL = new long[n];
            long[] eR = new long[n];
            long inf = 2000000007L;

            for (int i = 0; i < n; i++) {
                int p = Arrays.binarySearch(b, a[i]);
                int ip = -(p + 1);

                long ml = (ip > 0) ? (a[i] - b[ip - 1] - 1) : inf;
                long mr = (ip < m) ? (b[ip] - a[i] - 1) : inf;

                eL[i] = (ml << 32) | i;
                eR[i] = (mr << 32) | i;
            }

            Arrays.sort(eL);
            Arrays.sort(eR);

            boolean[] dd = new boolean[n];
            int ac = n;
            long cv = 0;
            long mlv = 0;
            long mrv = 0;
            int pl = 0;
            int pr = 0;

            for (int i = 0; i < k; i++) {
                if (s[i] == 'L') cv--;
                else cv++;

                if (-cv > mlv) mlv = -cv;
                if (cv > mrv) mrv = cv;

                while (pl < n && (eL[pl] >>> 32) < mlv) {
                    int id = (int) (eL[pl] & 0xFFFFFFFFL);
                    if (!dd[id]) {
                        dd[id] = true;
                        ac--;
                    }
                    pl++;
                }

                while (pr < n && (eR[pr] >>> 32) < mrv) {
                    int id = (int) (eR[pr] & 0xFFFFFFFFL);
                    if (!dd[id]) {
                        dd[id] = true;
                        ac--;
                    }
                    pr++;
                }

                out.print(ac + " ");
            }
            out.println();
        }
        out.flush();
    }

    static class FastScanner {
        InputStream is = System.in;
        byte[] buf = new byte[32768];
        int head, tail;

        int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = is.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        int nextInt() throws Exception {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }
}