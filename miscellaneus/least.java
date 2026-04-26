import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] two;
    private static int[][] five;
    private static char[][] path2;
    private static char[][] path5;

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        n = fs.nextInt();

        two = new int[n][n];
        five = new int[n][n];

        int zeroRow = -1;
        int zeroCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int val = fs.nextInt();

                if (val == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    val = 10;
                }

                two[i][j] = count(val, 2);
                five[i][j] = count(val, 5);
            }
        }

        int[][] dp2 = new int[n][n];
        int[][] dp5 = new int[n][n];

        path2 = new char[n][n];
        path5 = new char[n][n];

        final int INF = 1_000_000_000;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp2[i], INF);
            Arrays.fill(dp5[i], INF);
        }

        dp2[0][0] = two[0][0];
        dp5[0][0] = five[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i > 0) {
                    if (dp2[i][j] > dp2[i - 1][j] + two[i][j]) {
                        dp2[i][j] = dp2[i - 1][j] + two[i][j];
                        path2[i][j] = 'D';
                    }
                    if (dp5[i][j] > dp5[i - 1][j] + five[i][j]) {
                        dp5[i][j] = dp5[i - 1][j] + five[i][j];
                        path5[i][j] = 'D';
                    }
                }

                if (j > 0) {
                    if (dp2[i][j] > dp2[i][j - 1] + two[i][j]) {
                        dp2[i][j] = dp2[i][j - 1] + two[i][j];
                        path2[i][j] = 'R';
                    }
                    if (dp5[i][j] > dp5[i][j - 1] + five[i][j]) {
                        dp5[i][j] = dp5[i][j - 1] + five[i][j];
                        path5[i][j] = 'R';
                    }
                }
            }
        }

        int best2 = dp2[n - 1][n - 1];
        int best5 = dp5[n - 1][n - 1];

        if (zeroRow != -1 && Math.min(best2, best5) > 1) {

            System.out.println(1);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < zeroRow; i++) sb.append('D');
            for (int j = 0; j < zeroCol; j++) sb.append('R');
            for (int i = zeroRow; i < n - 1; i++) sb.append('D');
            for (int j = zeroCol; j < n - 1; j++) sb.append('R');

            System.out.println(sb.toString());
            return;
        }

        if (best2 <= best5) {
            System.out.println(best2);
            System.out.println(buildPath(path2));
        } else {
            System.out.println(best5);
            System.out.println(buildPath(path5));
        }
    }

    private static String buildPath(char[][] path) {

        StringBuilder sb = new StringBuilder();

        int i = n - 1;
        int j = n - 1;

        while (i > 0 || j > 0) {

            char c = path[i][j];
            sb.append(c);

            if (c == 'D') {
                i--;
            } else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    private static int count(int val, int d) {

        int cnt = 0;

        while (val % d == 0) {
            cnt++;
            val /= d;
        }

        return cnt;
    }

    private static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr, len;

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
                val = val * 10 + c - '0';
                c = read();
            }

            return val * sign;
        }
    }
}