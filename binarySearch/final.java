import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
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
        FastScanner fs = new FastScanner();
        String tStr = fs.next();
        if (tStr == null) return;
        int t = Integer.parseInt(tStr);
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            long h = fs.nextLong();
            int n = fs.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextLong();
            }

            long[] c = new long[n];
            for (int i = 0; i < n; i++) {
                c[i] = fs.nextLong();
            }

            long li = 1;
            long rb = 40000000005L;
            long ans = 1;

            while (li <= rb) {
                long turns = li + (rb - li) / 2;
                long dmg = 0;
                boolean killed = false;

                for (int i = 0; i < n; i++) {
                    dmg += a[i] + ((turns - 1) / c[i]) * a[i];
                    if (dmg >= h) {
                        killed = true;
                        break;
                    }
                }

                if (killed) {
                    ans = turns;
                    rb = turns - 1;
                } else {
                    li = turns + 1;
                }
            }
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}