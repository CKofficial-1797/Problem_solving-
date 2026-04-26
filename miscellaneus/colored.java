import java.util.*;
import java.io.*;

public class Main {

    private static final int MOD = 998244353;

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        int[] a = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
            total += a[i];
        }

        Arrays.sort(a);

        long[] dp = new long[total + 1];
        dp[0] = 1;

        long answer = 0;
        int currentMaxSum = 0;

        for (int i = 0; i < n; i++) {

            int x = a[i];

            for (int s = 0; s <= currentMaxSum; s++) {

                long ways = dp[s];
                if (ways == 0) continue;

                int newSum = s + x;

                int value;

                if (newSum <= 2 * x) {
                    value = x;
                } else {
                    value = (newSum + 1) / 2;
                }

                answer += (long) value * ways;
                if (answer >= MOD) answer %= MOD;
            }

            for (int s = currentMaxSum; s >= 0; s--) {
                if (dp[s] != 0) {
                    dp[s + x] = (dp[s + x] + dp[s]) % MOD;
                }
            }

            currentMaxSum += x;
        }

        System.out.println(answer % MOD);
    }

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
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }
}