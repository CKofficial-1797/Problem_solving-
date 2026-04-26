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

            long[] a = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                a[i] = fs.nextLong();
            }

            long[] prefRight = new long[n + 1];
            long[] prefLeft = new long[n + 2];

            for (int i = 1; i < n; i++) {

                long leftDist =
                        (i == 1) ? Long.MAX_VALUE : a[i] - a[i - 1];

                long rightDist =
                        a[i + 1] - a[i];

                long stepCost;

                if (rightDist < leftDist) {
                    stepCost = 1;
                } else {
                    stepCost = rightDist;
                }

                prefRight[i + 1] =
                        prefRight[i] + stepCost;
            }

            for (int i = n; i > 1; i--) {

                long rightDist =
                        (i == n) ? Long.MAX_VALUE : a[i + 1] - a[i];

                long leftDist =
                        a[i] - a[i - 1];

                long stepCost;

                if (leftDist < rightDist) {
                    stepCost = 1;
                } else {
                    stepCost = leftDist;
                }

                prefLeft[i - 1] =
                        prefLeft[i] + stepCost;
            }

            int q = fs.nextInt();

            while (q-- > 0) {

                int x = fs.nextInt();
                int y = fs.nextInt();

                if (x < y) {
                    out.append(
                        prefRight[y] - prefRight[x]
                    );
                } else {
                    out.append(
                        prefLeft[y] - prefLeft[x]
                    );
                }

                out.append('\n');
            }
        }

        System.out.print(out);
    }
}