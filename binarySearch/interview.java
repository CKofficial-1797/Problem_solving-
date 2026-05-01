import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int special = fs.nextInt();

            int[] arr = new int[n + 1];
            long[] pref = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = fs.nextInt();
                pref[i] = pref[i - 1] + arr[i];
            }

            int left = 1;
            int right = n;

            while (left < right) {
                int mid = left + (right - left) / 2;

                long expected = pref[mid] - pref[left - 1];
                long actual = expected;

                if (special >= left && special <= mid) {
                    actual += 1;
                }

                if (actual > expected) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            out.append(left).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr, len;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                ptr = 0;
                len = in.read(buf);
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            boolean neg = c == '-';
            if (neg) c = read();

            int val = c - '0';

            while ((c = read()) > ' ')
                val = val * 10 + c - '0';

            return neg ? -val : val;
        }
    }
}