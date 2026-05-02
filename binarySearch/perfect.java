import java.io.*;

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

        long nextLong() throws IOException {
            int c = read();
            while (c <= 32) c = read();

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > 32) {
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();

        int q = fs.nextInt();

        while (q-- > 0) {
            long coders = fs.nextLong();
            long mathers = fs.nextLong();
            long others = fs.nextLong();

            long totalPeople = coders + mathers + others;

            long teams = Math.min(
                    Math.min(coders, mathers),
                    totalPeople / 3
            );

            out.append(teams).append('\n');
        }

        System.out.print(out);
    }
}