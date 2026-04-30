import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static long w;
    static long h;
    static long n;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        w = fs.nextLong();
        h = fs.nextLong();
        n = fs.nextLong();

        long left = 0;
        long right = 1;

        while (!canFit(right)) {
            right *= 2;
        }

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canFit(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(left);
    }

    static boolean canFit(long side) {
        long countW = side / w;
        long countH = side / h;

        if (countW == 0 || countH == 0) return false;

        return countW >= (n + countH - 1) / countH;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}