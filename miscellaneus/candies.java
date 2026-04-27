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
    }

    public static void main(String[] args) throws Exception {
        FastInput fs = new FastInput(System.in);

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }

            int leftIndex = 0;
            int rightIndex = n - 1;

            long leftSum = 0;
            long rightSum = 0;

            int bestCount = 0;

            while (leftIndex <= rightIndex) {

                if (leftSum <= rightSum) {
                    leftSum += arr[leftIndex];
                    leftIndex++;
                } else {
                    rightSum += arr[rightIndex];
                    rightIndex--;
                }

                if (leftSum == rightSum) {
                    int eaten = leftIndex + (n - 1 - rightIndex);
                    if (eaten > bestCount) {
                        bestCount = eaten;
                    }
                }
            }

            System.out.println(bestCount);
        }
    }
}