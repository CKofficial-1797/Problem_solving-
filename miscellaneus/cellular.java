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
        int m = fs.nextInt();

        int[] cities = new int[n];
        int[] towers = new int[m];

        for (int i = 0; i < n; i++) {
            cities[i] = fs.nextInt();
        }

        for (int i = 0; i < m; i++) {
            towers[i] = fs.nextInt();
        }

        int towerIndex = 0;
        int maxRadius = 0;

        for (int i = 0; i < n; i++) {
            int city = cities[i];

            while (towerIndex + 1 < m &&
                   Math.abs(towers[towerIndex + 1] - city) <=
                   Math.abs(towers[towerIndex] - city)) {
                towerIndex++;
            }

            int dist = Math.abs(towers[towerIndex] - city);

            if (dist > maxRadius) {
                maxRadius = dist;
            }
        }

        System.out.println(maxRadius);
    }
}