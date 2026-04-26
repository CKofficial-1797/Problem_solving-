import java.io.*;
import java.util.*;

public class Main {

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

    static int dist(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int hx = fs.nextInt();
        int hy = fs.nextInt();

        int n = fs.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }

        int size = 1 << n;

        int[] dp = new int[size];
        int[] parent = new int[size];
        int[] take = new int[size];

        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int mask = 0; mask < size; mask++) {

            if (dp[mask] >= Integer.MAX_VALUE / 2) continue;

            int first = -1;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    first = i;
                    break;
                }
            }

            if (first == -1) continue;

            int aloneMask = mask | (1 << first);

            int costAlone =
                    dist(hx, hy, x[first], y[first]) +
                    dist(x[first], y[first], hx, hy);

            if (dp[aloneMask] > dp[mask] + costAlone) {
                dp[aloneMask] = dp[mask] + costAlone;
                parent[aloneMask] = mask;
                take[aloneMask] = first;
            }

            for (int j = first + 1; j < n; j++) {

                if ((mask & (1 << j)) != 0) continue;

                int pairMask = mask | (1 << first) | (1 << j);

                int costPair =
                        dist(hx, hy, x[first], y[first]) +
                        dist(x[first], y[first], x[j], y[j]) +
                        dist(x[j], y[j], hx, hy);

                if (dp[pairMask] > dp[mask] + costPair) {
                    dp[pairMask] = dp[mask] + costPair;
                    parent[pairMask] = mask;
                    take[pairMask] = first | (j << 5);
                }
            }
        }

        int full = size - 1;

        System.out.println(dp[full]);

        List<Integer> path = new ArrayList<>();

        int cur = full;

        while (cur != 0) {

            path.add(0);

            int info = take[cur];

            int i = info & 31;
            int j = info >> 5;

            path.add(i + 1);

            if (j != 0) {
                path.add(j + 1);
            }

            cur = parent[cur];
        }

        path.add(0);

        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();

        for (int v : path) {
            sb.append(v).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}