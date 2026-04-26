import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_007;

    static int[] primes = {
        2, 3, 5, 7, 11, 13, 17, 19, 23,
        29, 31, 37, 41, 43, 47, 53, 59,
        61, 67
    };

    static long[] pow2;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        int[] freq = new int[71];
        for (int i = 0; i < n; i++) {
            freq[fs.nextInt()]++;
        }

        int maxMask = 1 << primes.length;

        buildPowers(n);

        long[] dp = new long[maxMask];
        dp[0] = 1;

        for (int val = 1; val <= 70; val++) {
            int c = freq[val];
            if (c == 0) continue;

            int mask = buildMask(val);

            long evenWays = pow2[c - 1];
            long oddWays  = pow2[c - 1];

            long[] next = new long[maxMask];

            for (int s = 0; s < maxMask; s++) {
                if (dp[s] == 0) continue;

                long cur = dp[s];

                next[s] = (next[s] + cur * evenWays) % MOD;

                int ns = s ^ mask;
                next[ns] = (next[ns] + cur * oddWays) % MOD;
            }

            dp = next;
        }

        long ans = dp[0] - 1;
        if (ans < 0) ans += MOD;

        System.out.println(ans);
    }

    static int buildMask(int x) {
        int m = 0;

        for (int i = 0; i < primes.length; i++) {
            int p = primes[i];
            int cnt = 0;

            while (x % p == 0) {
                x /= p;
                cnt++;
            }

            if ((cnt & 1) == 1) {
                m |= (1 << i);
            }
        }

        return m;
    }

    static void buildPowers(int n) {
        pow2 = new long[n + 1];
        pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
    }

    static class FastScanner {
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
}