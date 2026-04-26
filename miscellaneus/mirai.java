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
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        long[] sorted = arr.clone();
        Arrays.sort(sorted);

        long[] pref = buildPrefix(arr);
        long[] prefSorted = buildPrefix(sorted);

        int q = fs.nextInt();

        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            int type = fs.nextInt();
            int l = fs.nextInt();
            int r = fs.nextInt();

            long ans;
            if (type == 1) {
                ans = rangeSum(pref, l, r);
            } else {
                ans = rangeSum(prefSorted, l, r);
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    private static long[] buildPrefix(long[] data) {
        int n = data.length;
        long[] pref = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + data[i - 1];
        }

        return pref;
    }

    private static long rangeSum(long[] pref, int l, int r) {
        return pref[r] - pref[l - 1];
    }
}