import java.io.*;
import java.util.*;

public class Main {

    private static class FS {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FS(InputStream is) {
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

        FS fs = new FS(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            int s = fs.nextInt();

            int[] arr = new int[n];
            int total = 0;

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                total += arr[i];
            }

            if (total < s) {
                out.append(-1).append('\n');
                continue;
            }

            int leftIndex = 0;
            int currSum = 0;
            int maxLen = -1;

            for (int rightBound = 0; rightBound < n; rightBound++) {

                currSum += arr[rightBound];

                while (currSum > s) {
                    currSum -= arr[leftIndex];
                    leftIndex++;
                }

                if (currSum == s) {
                    int len = rightBound - leftIndex + 1;
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }

            if (maxLen == -1) {
                out.append(-1).append('\n');
            } else {
                out.append(n - maxLen).append('\n');
            }
        }

        System.out.print(out);
    }
}