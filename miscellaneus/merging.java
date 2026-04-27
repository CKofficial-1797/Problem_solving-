import java.io.*;
import java.util.*;

public class Main {

    private static class FastScanner {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
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
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }

        for (int j = 0; j < m; j++) {
            b[j] = fs.nextInt();
        }

        int i = 0;
        int j = 0;

        StringBuilder out = new StringBuilder();

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                out.append(a[i]).append(' ');
                i++;
            } else {
                out.append(b[j]).append(' ');
                j++;
            }
        }

        while (i < n) {
            out.append(a[i]).append(' ');
            i++;
        }

        while (j < m) {
            out.append(b[j]).append(' ');
            j++;
        }

        System.out.println(out.toString());
    }
}