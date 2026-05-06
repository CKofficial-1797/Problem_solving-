import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            byte[] a = new byte[n];
            sc.readString(a);

            int[] zeros = new int[n + 1];
            int[] ones = new int[n + 1];

            for (int i = 0; i < n; i++) {
                zeros[i + 1] = zeros[i] + (a[i] == '0' ? 1 : 0);
                ones[i + 1] = ones[i] + (a[i] == '1' ? 1 : 0);
            }

            int bestI = -1;
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i <= n; i++) {
                int leftReq = (i + 1) / 2;
                int rightReq = (n - i + 1) / 2;

                if (zeros[i] >= leftReq && (ones[n] - ones[i]) >= rightReq) {
                    int dist = Math.abs(n - 2 * i);
                    if (dist < minDist) {
                        minDist = dist;
                        bestI = i;
                    }
                }
            }
            out.println(bestI);
        }
        out.flush();
    }

    static class FastScanner {
        InputStream is = System.in;
        byte[] buf = new byte[32768];
        int head, tail;

        int read() throws Exception {
            if (head >= tail) {
                head = 0;
                tail = is.read(buf, 0, buf.length);
                if (tail <= 0) return -1;
            }
            return buf[head++];
        }

        int nextInt() throws Exception {
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

        int readString(byte[] str) throws Exception {
            int c = read();
            while (c <= 32) {
                if (c == -1) return 0;
                c = read();
            }
            int len = 0;
            while (c > 32) {
                str[len++] = (byte) c;
                c = read();
            }
            return len;
        }
    }
}