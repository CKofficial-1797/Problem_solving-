import java.io.InputStream;
import java.io.IOException;

public class Main {

    static class FastScanner {
        private final InputStream src = System.in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = src.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        long nextLong() throws IOException {
            int ch = read();
            while (ch <= 32) ch = read();

            int sign = 1;
            if (ch == '-') {
                sign = -1;
                ch = read();
            }

            long val = 0;
            while (ch > 32) {
                val = val * 10 + (ch - '0');
                ch = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int t = fs.nextInt();
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            long x = fs.nextLong();
            long y = fs.nextLong();
            long a = fs.nextLong();
            long b = fs.nextLong();

            long left = 0;
            long right = (x + y) / (a + b); // hard upper bound

            while (left < right) {
                long mid = (left + right + 1) / 2;

                if (canMake(mid, x, y, a, b)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            out.append(left).append('\n');
        }

        System.out.print(out);
    }

    private static boolean canMake(long sets,
                                   long red,
                                   long blue,
                                   long a,
                                   long b) {

        // Find range of k (type-1 sets)

        long low = 0;
        long high = sets;

        if (a != b) {
            // From red constraint
            long num1 = red - b * sets;
            if (a > b) {
                long kMin = ceilDiv(num1, a - b);
                if (kMin > low) low = kMin;
            } else {
                long kMax = floorDiv(num1, a - b);
                if (kMax < high) high = kMax;
            }

            // From blue constraint
            long num2 = blue - a * sets;
            if (b > a) {
                long kMin = ceilDiv(num2, b - a);
                if (kMin > low) low = kMin;
            } else {
                long kMax = floorDiv(num2, b - a);
                if (kMax < high) high = kMax;
            }
        } else {
            // symmetric case
            if (a * sets > red || a * sets > blue) {
                return false;
            }
        }

        return low <= high;
    }

    private static long ceilDiv(long a, long b) {
        if (b < 0) {
            a = -a;
            b = -b;
        }
        if (a >= 0) {
            return (a + b - 1) / b;
        } else {
            return a / b;
        }
    }

    private static long floorDiv(long a, long b) {
        if (b < 0) {
            a = -a;
            b = -b;
        }
        if (a >= 0) {
            return a / b;
        } else {
            return (a - b + 1) / b;
        }
    }
}