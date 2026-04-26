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

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
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
            int k = fs.nextInt();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }

            Arrays.sort(arr);

            long[] pref = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i - 1] + arr[i - 1];
            }

            long best = 0;

            for (int x = 0; x <= k; x++) {

                int leftRemoved = 2 * x;
                int rightRemoved = k - x;

                int rightIndex = n - rightRemoved;

                if (leftRemoved <= rightIndex) {

                    long remaining =
                            pref[rightIndex] - pref[leftRemoved];

                    if (remaining > best) {
                        best = remaining;
                    }
                }
            }

            out.append(best).append('\n');
        }

        System.out.print(out);
    }
}