import java.io.InputStream;
import java.io.IOException;

public class Main {

    // Fast input without unnecessary abstraction
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

        int n = fs.nextInt();

        long sum = 0;
        long maxNeed = 0;

        for (int i = 0; i < n; i++) {
            long val = fs.nextLong();
            sum += val;
            if (val > maxNeed) {
                maxNeed = val;
            }
        }

        // ceil(sum / (n - 1))
        long slotsLimit = (sum + (n - 2)) / (n - 1);

        long rounds = Math.max(maxNeed, slotsLimit);

        System.out.println(rounds);
    }
}