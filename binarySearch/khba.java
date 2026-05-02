import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);

            long li = 0, rb = x, ans = 0;
            while (li <= rb) {
                long mid = li + (rb - li) / 2;
                if (check(a, n, k, x, mid)) {
                    ans = mid;
                    li = mid + 1;
                } else {
                    rb = mid - 1;
                }
            }

            long cL = -1, cR = -2;
            long curr = 0;
            int printed = 0;

            for (int i = 0; i < n; i++) {
                long L = Math.max(0L, (long)a[i] - ans + 1);
                long R = Math.min((long)x, (long)a[i] + ans - 1);
                if (L > R) continue;

                if (cL == -1) {
                    cL = L; cR = R;
                } else if (L <= cR + 1) {
                    cR = Math.max(cR, R);
                } else {
                    while (curr < cL && printed < k) {
                        out.print(curr + " ");
                        curr++;
                        printed++;
                    }
                    curr = Math.max(curr, cR + 1);
                    cL = L; cR = R;
                }
            }
            
            if (cL != -1) {
                while (curr < cL && printed < k) {
                    out.print(curr + " ");
                    curr++;
                    printed++;
                }
                curr = Math.max(curr, cR + 1);
            }

            while (curr <= x && printed < k) {
                out.print(curr + " ");
                curr++;
                printed++;
            }
            out.println();
        }
        out.flush();
    }

    static boolean check(int[] a, int n, int k, int x, long D) {
        if (D == 0) return true;
        long bad = 0;
        long cL = -1, cR = -2;
        for (int i = 0; i < n; i++) {
            long L = Math.max(0L, (long)a[i] - D + 1);
            long R = Math.min((long)x, (long)a[i] + D - 1);
            if (L > R) continue;
            if (cL == -1) {
                cL = L; cR = R;
            } else if (L <= cR + 1) {
                cR = Math.max(cR, R);
            } else {
                bad += (cR - cL + 1);
                cL = L; cR = R;
            }
        }
        if (cL != -1) {
            bad += (cR - cL + 1);
        }
        return (x + 1L - bad) >= k;
    }

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
    }
}