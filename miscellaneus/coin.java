import java.io.*;
import java.util.*;

public class coin {

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            coins[i] =
                    Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[x + 1];

        dp[0] = 1;

        for (int sum = 1; sum <= x; sum++) {

            int ways = 0;

            for (int i = 0; i < n; i++) {

                int rem = sum - coins[i];

                if (rem < 0) continue;

                ways += dp[rem];

                if (ways >= mod) {
                    ways -= mod;
                }
            }

            dp[sum] = ways;
        }

        System.out.println(dp[x]);
    }
}