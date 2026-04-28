import java.io.InputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int head, tail;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = stream.read(buf, 0, buf.length);
                if (tail <= 0) {
                    return -1;
                }
            }
            return buf[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) {
                    return -1;
                }
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }

        public long nextLong() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) {
                    return -1;
                }
                c = read();
            }
            long res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        if (t == -1) return;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            long x = fs.nextLong();

            int[] a = new int[n];
            long totSum = 0;
            
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
                totSum += a[i];
            }

            Arrays.sort(a);

            int k = (int) (totSum / x);
            int ps = n - k - 1;
            int pl = n - 1;

            long curSum = 0;
            long bonus = 0;
            int[] res = new int[n];

            for (int i = 0; i < n; i++) {
                long rem = x - (curSum % x);
                if (pl >= n - k && a[pl] >= rem) {
                    res[i] = a[pl];
                    bonus += a[pl];
                    curSum += a[pl];
                    pl--;
                } else {
                    res[i] = a[ps];
                    curSum += a[ps];
                    ps--;
                }
            }

            sb.append(bonus).append('\n');
            for (int i = 0; i < n; i++) {
                sb.append(res[i]);
                if (i < n - 1) {
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        
        System.out.print(sb.toString());
    }
}