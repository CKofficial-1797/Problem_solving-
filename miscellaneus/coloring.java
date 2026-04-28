import java.io.InputStream;
import java.io.IOException;

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
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    static int getFirstGreaterOrEqual(int[] a, int li, int rb, int val) {
        int res = rb + 1;
        while (li <= rb) {
            int mid = li + (rb - li) / 2;
            if (a[mid] >= val) {
                res = mid;
                rb = mid - 1;
            } else {
                li = mid + 1;
            }
        }
        return res;
    }

    static int getFirstGreater(int[] a, int li, int rb, int val) {
        int res = rb + 1;
        while (li <= rb) {
            int mid = li + (rb - li) / 2;
            if (a[mid] > val) {
                res = mid;
                rb = mid - 1;
            } else {
                li = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        if (t == -1) return;

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            long ans = 0;
            int maxA = a[n - 1];

            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    int s = a[i] + a[j];
                    int minV = maxA - s + 1;
                    int maxV = s - 1;

                    if (minV > maxV) continue;

                    int lIdx = getFirstGreaterOrEqual(a, j + 1, n - 1, minV);
                    int rIdx = getFirstGreater(a, j + 1, n - 1, maxV) - 1;

                    if (lIdx <= rIdx) {
                        ans += (rIdx - lIdx + 1);
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}