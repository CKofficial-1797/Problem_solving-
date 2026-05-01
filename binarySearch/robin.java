import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static long[] arr;
    static long sum;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            n = fs.nextInt();

            arr = new long[n];
            sum = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
                sum += arr[i];
            }

            if (n <= 2) {
                out.append("-1\n");
                continue;
            }

            Arrays.sort(arr);

            long left = 0;
            long right = (long) 2e14;
            long ans = -1;

            while (left <= right) {
                long mid = left + (right - left) / 2;

                if (works(mid)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    static boolean works(long x) {
        double thr = (sum + x) / (2.0 * n);

        int idx = lowerBound(thr);

        return idx > n / 2;
    }

    static int lowerBound(double val) {
        int li = 0;
        int ri = n;

        while (li < ri) {
            int mid = li + (ri - li) / 2;

            if (arr[mid] < val) {
                li = mid + 1;
            } else {
                ri = mid;
            }
        }

        return li;
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

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            boolean neg = c == '-';
            if (neg) c = read();

            long val = c - '0';

            while ((c = read()) > ' ')
                val = val * 10 + c - '0';

            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}