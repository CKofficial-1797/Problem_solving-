import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
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

            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = fs.nextInt();
            }

            ArrayList<Integer> validIdx = new ArrayList<>();
            long pairCount = 0;

            for (int j = 1; j <= n; j++) {
                if (arr[j] < j) {

                    int pos = countLess(validIdx, arr[j]);
                    pairCount += pos;

                    validIdx.add(j);
                }
            }

            out.append(pairCount).append('\n');
        }

        System.out.print(out);
    }

    private static int countLess(ArrayList<Integer> list, int bound) {
        int leftIndex = 0;
        int rightBound = list.size();

        while (leftIndex < rightBound) {
            int mid = leftIndex + (rightBound - leftIndex) / 2;

            if (list.get(mid) < bound) {
                leftIndex = mid + 1;
            } else {
                rightBound = mid;
            }
        }

        return leftIndex;
    }
}