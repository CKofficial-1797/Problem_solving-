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

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            long L = fs.nextLong();
            long R = fs.nextLong();

            long[] arr = new long[n];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextLong();
            }

            Arrays.sort(arr);

            long ans =
                    countAtMost(arr, R)
                    - countAtMost(arr, L - 1);

            System.out.println(ans);
        }
    }

    private static long countAtMost(long[] arr, long limit) {
        int left = 0;
        int right = arr.length - 1;

        long count = 0;

        while (left < right) {
            long sum = arr[left] + arr[right];

            if (sum <= limit) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}