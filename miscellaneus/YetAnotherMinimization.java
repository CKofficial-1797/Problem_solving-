import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] a = new int[n];
            int[] b = new int[n];

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int total = 0;
            int sqSum = 0;

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                total += a[i];
                sqSum += a[i] * a[i];
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
                total += b[i];
                sqSum += b[i] * b[i];
            }

            boolean[] dp =
                    new boolean[total + 1];

            dp[0] = true;

            for (int i = 0; i < n; i++) {

                boolean[] next =
                        new boolean[total + 1];

                for (int s = 0; s <= total; s++) {

                    if (!dp[s])
                        continue;

                    next[s + a[i]] = true;
                    next[s + b[i]] = true;
                }

                dp = next;
            }

            int best = Integer.MAX_VALUE;

            for (int s = 0; s <= total; s++) {

                if (!dp[s])
                    continue;

                int other = total - s;

                int cost =
                        s * s
                      + other * other;

                if (cost < best)
                    best = cost;
            }

            int answer =
                    best
                  + (n - 2) * sqSum;

            System.out.println(answer);
        }
    }
}