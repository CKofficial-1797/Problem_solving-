import java.io.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, size = 0;

        private int read() throws IOException {
            if (ptr >= size) {
                size = in.read(buffer);
                ptr = 0;
                if (size <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c = read();
            while (c <= 32) c = read();

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > 32) {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder ans = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            long n = fs.nextLong();
            ans.append(findMinBalls(n)).append('\n');
        }

        System.out.print(ans);
    }

    private static long findMinBalls(long target) {
        long leftIndex = 1;
        long rightBound = 2_000_000_000L;

        while (leftIndex < rightBound) {
            long mid = leftIndex + (rightBound - leftIndex) / 2;

            long ways = mid * (mid + 1) / 2;

            if (ways >= target) {
                rightBound = mid;
            } else {
                leftIndex = mid + 1;
            }
        }

        return leftIndex;
    }
}