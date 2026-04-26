import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int k = fs.nextInt();

            long[] arr = new long[n];

            long total = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
                total += arr[i];
            }

            long bestGain = 0;

            int maxLen = k + 1;

            for (int left = 0; left < n; left++) {

                long sum = 0;
                long mn = Long.MAX_VALUE;

                for (int len = 1; len <= maxLen; len++) {

                    int right = left + len - 1;
                    if (right >= n) break;

                    long val = arr[right];

                    sum += val;

                    if (val < mn) {
                        mn = val;
                    }

                    long gain = sum - mn * len;

                    if (gain > bestGain) {
                        bestGain = gain;
                    }
                }
            }

            long answer = total - bestGain;

            out.append(answer).append('\n');
        }

        System.out.print(out);
    }

    private static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr, len;

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
            return (int) nextLong();
        }

        long nextLong() throws IOException {

            int c;

            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;

            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }
}