import java.io.*;
import java.util.*;

public class Main {

    private static class FS {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FS(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FS fs = new FS(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int q = fs.nextInt();

            long[] pref = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i - 1] + fs.nextInt();
            }

            long total = pref[n];

            for (int i = 0; i < q; i++) {

                int l = fs.nextInt();
                int r = fs.nextInt();
                int k = fs.nextInt();

                long segment = pref[r] - pref[l - 1];
                long len = r - l + 1;

                long newSum = total - segment + (long) k * len;

                if ((newSum & 1L) == 1L) {
                    out.append("YES\n");
                } else {
                    out.append("NO\n");
                }
            }
        }

        System.out.print(out);
    }
}