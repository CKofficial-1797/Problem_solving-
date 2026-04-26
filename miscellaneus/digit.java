import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 200000;

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

        long[] pref = buildPrefix();

        int t = fs.nextInt();

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            out.append(pref[n]).append('\n');
        }

        System.out.print(out);
    }

    private static long[] buildPrefix() {

        long[] pref = new long[MAX + 1];
        int[] digit = new int[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            digit[i] = digit[i / 10] + (i % 10);
            pref[i] = pref[i - 1] + digit[i];
        }

        return pref;
    }
}