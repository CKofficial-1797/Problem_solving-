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

        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        Map<Integer, Integer> freq = new HashMap<>();

        int leftIndex = 0;
        int distinct = 0;

        long windowSum = 0;
        long bestSum = 0;

        for (int rightIndex = 0; rightIndex < n; rightIndex++) {

            int val = arr[rightIndex];

            windowSum += val;

            int count = freq.getOrDefault(val, 0) + 1;
            freq.put(val, count);

            if (count == 1) {
                distinct++;
            }

            while (distinct > k) {

                int leftVal = arr[leftIndex];

                windowSum -= leftVal;

                int leftCount = freq.get(leftVal) - 1;

                if (leftCount == 0) {
                    freq.remove(leftVal);
                    distinct--;
                } else {
                    freq.put(leftVal, leftCount);
                }

                leftIndex++;
            }

            if (windowSum > bestSum) {
                bestSum = windowSum;
            }
        }

        System.out.println(bestSum);
    }
}