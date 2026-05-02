import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, size = 0;

        private int read() throws IOException {
            if (ptr >= size) {
                size = in.read(buf);
                ptr = 0;
                if (size <= 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c = read();
            while (c <= 32) c = read();

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32) {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            for (int i = 0; i < n; i++) {
                fs.nextInt();
            }

            int leftIndex = fs.nextInt();
            int rightBound = fs.nextInt();

            out.append(leftIndex)
               .append(' ')
               .append(rightBound)
               .append('\n');
        }

        System.out.print(out);
    }
}