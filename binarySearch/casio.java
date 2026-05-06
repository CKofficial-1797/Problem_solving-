import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[][] a = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = fs.nextInt();
                }
                Arrays.sort(a[i]); // critical
            }

            long ans = 0;

            for (int col = 0; col < m; col++) {

                int[] temp = new int[n];
                for (int i = 0; i < n; i++) {
                    temp[i] = a[i][col];
                }

                Arrays.sort(temp);

                long prefix = 0;

                for (int i = 0; i < n; i++) {
                    ans += (long) temp[i] * i - prefix;
                    prefix += temp[i];
                }
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    // fast input
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
    }
}