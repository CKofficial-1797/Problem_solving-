import java.io.*;
import java.util.*;

public class Main {

    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
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

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return null;
            }
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int k = fs.nextInt();

        String s = fs.next();

        int[] pref = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            int val = (ch == 'W') ? 1 : -1;
            pref[i] = pref[i - 1] + val;
        }

        StringBuilder ans = new StringBuilder();

        for (int q = 0; q < k; q++) {
            int l = fs.nextInt();
            int r = fs.nextInt();

            int rSum = pref[r] - pref[l - 1];

            if (rSum > 0) {
                ans.append('Y');
            } else {
                ans.append('N');
            }
        }

        System.out.println(ans.toString());
    }
}