import java.util.*;
import java.io.*;

public class Main {

    private static class Item {
        long w;
        int idx;

        Item(long w, int idx) {
            this.w = w;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            int n = fs.nextInt();
            long W = fs.nextLong();

            long low = (W + 1) / 2;

            List<Item> small = new ArrayList<>();
            int singleIndex = -1;

            for (int i = 1; i <= n; i++) {
                long w = fs.nextLong();

                if (w >= low && w <= W) {
                    singleIndex = i;
                } else if (w < low) {
                    small.add(new Item(w, i));
                }
            }

            if (singleIndex != -1) {
                out.append(1).append('\n');
                out.append(singleIndex).append('\n');
                continue;
            }

            long sum = 0;
            List<Integer> ans = new ArrayList<>();

            for (Item it : small) {
                if (sum + it.w <= W) {
                    sum += it.w;
                    ans.add(it.idx);
                }
                if (sum >= low) break;
            }

            if (sum >= low && sum <= W) {
                out.append(ans.size()).append('\n');
                for (int i = 0; i < ans.size(); i++) {
                    if (i > 0) out.append(' ');
                    out.append(ans.get(i));
                }
                out.append('\n');
            } else {
                out.append(-1).append('\n');
            }
        }

        System.out.print(out);
    }

    private static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }
}