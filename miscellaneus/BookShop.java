import java.util.*;
import java.io.*;

public class BookShop {

    private static int[] pages;
    private static int[] prices;
    private static int n, k;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        int ans = solve();
        System.out.println(ans);
    }

    private static int solve() {

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {

            int cost = prices[i];
            int value = pages[i];

            for (int p = k; p >= cost; p--) {

                int candidate = dp[p - cost] + value;

                if (candidate > dp[p]) {
                    dp[p] = candidate;
                }
            }
        }

        return dp[k];
    }
}