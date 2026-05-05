import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();

            long[] s = new long[k];
            for (int i = 0; i < k; i++) s[i] = fs.nextLong();

            if (k == 1) {
                out.append("YES\n");
                continue;
            }

            boolean ok = true;

            long prevDiff = Long.MIN_VALUE;

            for (int i = 1; i < k; i++) {
                long diff = s[i] - s[i - 1];

                if (i > 1 && diff < prevDiff) {
                    ok = false;
                }

                prevDiff = diff;
            }

            long firstDiff = s[1] - s[0];
            long len = n - k + 1;

            if (s[0] > firstDiff * len) {
                ok = false;
            }

            out.append(ok ? "YES\n" : "NO\n");
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c = read();
            while (c <= 32) c = read();

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }

        long nextLong() throws IOException {
            int c = read();
            while (c <= 32) c = read();

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
}