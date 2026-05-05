import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] a, b;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        n = fs.nextInt();
        k = fs.nextInt();

        a = new int[n];
        b = new int[n];

        for (int i = 0; i < n; i++) a[i] = fs.nextInt();
        for (int i = 0; i < n; i++) b[i] = fs.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);

        long left = (long) a[0] + b[0];
        long right = (long) a[n - 1] + b[n - 1];

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (count(mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    static long count(long target) {
        long cnt = 0;
        int j = n - 1;

        for (int i = 0; i < n; i++) {
            while (j >= 0 && (long) a[i] + b[j] > target) {
                j--;
            }
            cnt += (j + 1);
        }

        return cnt;
    }

    // fast input (no Scanner — too slow for CF)
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