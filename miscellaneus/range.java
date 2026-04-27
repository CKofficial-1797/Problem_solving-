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

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            long[] pref = new long[n + 1];
            long baseSum = 0;

            for (int i = 1; i <= n; i++) {
                int v = fs.nextInt();
                baseSum += v;
                pref[i] = pref[i - 1] + v;
            }

            long bestLeft = 0;
            long maxGain = 0;

            for (int r = 1; r <= n; r++) {

                long leftVal =
                        pref[r - 1]
                        - 1L * r * r
                        + r;

                if (leftVal > bestLeft) {
                    bestLeft = leftVal;
                }

                long rightVal =
                        1L * r * r
                        + r
                        - pref[r];

                long gain = bestLeft + rightVal;

                if (gain > maxGain) {
                    maxGain = gain;
                }
            }

            System.out.println(baseSum + maxGain);
        }
    }
}