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
    }

    public static void main(String[] args) throws Exception {
        FS fs = new FS(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int q = fs.nextInt();

            int[] steps = new int[n];

            for (int i = 0; i < n; i++) {
                steps[i] = fs.nextInt();
            }

            long[] prefSum = new long[n];
            int[] prefMax = new int[n];

            prefSum[0] = steps[0];
            prefMax[0] = steps[0];

            for (int i = 1; i < n; i++) {
                prefSum[i] = prefSum[i - 1] + steps[i];
                prefMax[i] = Math.max(prefMax[i - 1], steps[i]);
            }

            for (int i = 0; i < q; i++) {
                int k = fs.nextInt();

                int pos = lastReachable(prefMax, k);

                if (pos == -1) {
                    out.append(0);
                } else {
                    out.append(prefSum[pos]);
                }

                if (i + 1 < q) out.append(' ');
            }

            if (t > 0) out.append('\n');
        }

        System.out.print(out);
    }

    private static int lastReachable(int[] prefMax, int k) {

        int leftIndex = 0;
        int rightBound = prefMax.length - 1;
        int ans = -1;

        while (leftIndex <= rightBound) {

            int mid = leftIndex + (rightBound - leftIndex) / 2;

            if (prefMax[mid] <= k) {
                ans = mid;
                leftIndex = mid + 1;
            } else {
                rightBound = mid - 1;
            }
        }

        return ans;
    }
}