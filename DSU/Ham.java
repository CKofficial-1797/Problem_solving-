import java.util.*;
import java.io.*;

public class Ham {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        while (m-- > 0) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
        }

        int target = (1 << n) - 1;

        long[][] dp = new long[1 << n][n + 1];

        int startMask = 1;

        dp[startMask][1] = 1;

        for (int mask = 0; mask <= target; mask++) {

            for (int city = 1; city <= n; city++) {

                long ways = dp[mask][city];

                if (ways == 0) continue;

                for (int next : adj.get(city)) {

                    int bit = 1 << (next - 1);

                    if ((mask & bit) != 0) continue;

                    int nextMask = mask | bit;

                    dp[nextMask][next] =
                            (dp[nextMask][next] + ways) % MOD;
                }
            }
        }

        System.out.println(dp[target][n]);
    }
}