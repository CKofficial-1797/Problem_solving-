import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String s = br.readLine();
                    if (s == null) return null;
                    st = new StringTokenizer(s);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        String tStr = in.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);

        while (t-- > 0) {
            int n = in.nextInt();
            long os = (long) n * (n + 1) / 2;
            
            System.out.println("2 1 " + n);
            System.out.flush();
            long ms = in.nextLong();
            long k = ms - os;

            int li = 1;
            int rb = n;
            int fl = -1;
            int fr = -1;

            while (li <= rb) {
                int m = li + (rb - li) / 2;

                System.out.println("1 1 " + m);
                System.out.flush();
                long s1 = in.nextLong();

                System.out.println("2 1 " + m);
                System.out.flush();
                long s2 = in.nextLong();

                long sx = s2 - s1;

                if (sx == 0) {
                    li = m + 1;
                } else if (sx == k) {
                    fr = m;
                    rb = m - 1;
                } else {
                    fl = (int) (m - sx + 1);
                    fr = (int) (fl + k - 1);
                    break;
                }
            }

            if (fl == -1) {
                fl = (int) (fr - k + 1);
            }

            System.out.println("! " + fl + " " + fr);
            System.out.flush();
        }
    }
}