import java.io.*;
import java.util.*;

public class Main {

    private static class FastScanner {
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
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = fs.nextInt();
        }

        int[] pref = new int[n];
        pref[0] = piles[0];

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + piles[i];
        }

        int q = fs.nextInt();

        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            int worm = fs.nextInt();
            int idx = findPile(pref, worm);
            out.append(idx + 1).append('\n');
        }

        System.out.print(out);
    }

    private static int findPile(int[] pref, int target) {
        int leftIndex = 0;
        int rightBound = pref.length - 1;

        while (leftIndex < rightBound) {
            int mid = leftIndex + (rightBound - leftIndex) / 2;

            if (pref[mid] >= target) {
                rightBound = mid;
            } else {
                leftIndex = mid + 1;
            }
        }

        return leftIndex;
    }
}