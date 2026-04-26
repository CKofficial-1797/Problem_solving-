import java.util.*;

public class removing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int val = i;

            while (val > 0) {
                int digit = val % 10;
                val /= 10;

                if (digit == 0) continue;

                int prev = i - digit;
                if (prev >= 0 && dp[prev] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[prev] + 1);
                }
            }
        }

        System.out.println(dp[n]);
    }
}