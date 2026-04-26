import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            n = sc.nextInt();

            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            dp = new int[n][2];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            System.out.println(f(0, 1));
        }
    }

    private static int f(int id, int who) {

        if (id >= n) {
            return 0;
        }

        if (dp[id][who] != -1) {
            return dp[id][who];
        }

        int best;

        if (who == 1) {

            int cost1 = arr[id];
            best = cost1 + f(id + 1, 0);

            if (id + 1 < n) {
                int cost2 = arr[id] + arr[id + 1];
                best = Math.min(best,
                        cost2 + f(id + 2, 0));
            }

        } else {

            best = f(id + 1, 1);

            if (id + 1 < n) {
                best = Math.min(best,
                        f(id + 2, 1));
            }
        }

        dp[id][who] = best;
        return best;
    }
}