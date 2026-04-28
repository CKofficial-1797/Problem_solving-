import java.io.*;
import java.util.*;

public class Main {

    private static long solveCase(long x, int m,
                                  BufferedReader br) throws Exception {

        long left = x;
        long right = x;

        StringTokenizer st;

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            if (r < left || l > right) {
                continue;
            }

            left = Math.min(left, l);
            right = Math.max(right, r);
        }

        return right - left + 1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            long n = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long ans = solveCase(x, m, br);

            System.out.println(ans);
        }
    }
}