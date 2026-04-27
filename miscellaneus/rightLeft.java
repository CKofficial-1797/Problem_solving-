import java.io.*;
import java.util.*;

public class Main {

    private static class FastInput {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int head = 0, tail = 0;

        FastInput(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (head >= tail) {
                tail = in.read(buf);
                head = 0;
                if (tail <= 0) return -1;
            }
            return buf[head++];
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

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return null;
            }
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastInput fs = new FastInput(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] arr = new int[n];
            long[] pref = new long[n + 1];

            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                pref[i + 1] = pref[i] + arr[i];
            }

            String s = fs.next();

            int leftIndex = 0;
            int rightIndex = n - 1;

            long totalScore = 0;

            while (leftIndex < rightIndex) {

                while (leftIndex < n &&
                       s.charAt(leftIndex) != 'L') {
                    leftIndex++;
                }

                while (rightIndex >= 0 &&
                       s.charAt(rightIndex) != 'R') {
                    rightIndex--;
                }

                if (leftIndex < rightIndex) {

                    long segmentSum =
                            pref[rightIndex + 1]
                          - pref[leftIndex];

                    totalScore += segmentSum;

                    leftIndex++;
                    rightIndex--;
                }
            }

            System.out.println(totalScore);
        }
    }
}