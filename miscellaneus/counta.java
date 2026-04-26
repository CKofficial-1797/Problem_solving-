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

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return "";
            }

            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');

            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + c - '0';
            }

            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        String s = fs.next();
        int n = s.length();

        int q = fs.nextInt();

        int[] pref = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1];

            if (s.charAt(i - 1) == 'a') {
                pref[i]++;
            }
        }

        StringBuilder out = new StringBuilder();

        while (q-- > 0) {

            int L = fs.nextInt();
            int R = fs.nextInt();

            int ans = pref[R] - pref[L - 1];

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}