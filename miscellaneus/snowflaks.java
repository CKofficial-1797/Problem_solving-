import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            long n = Long.parseLong(br.readLine());

            if (exists(n)) out.append("YES\n");
            else out.append("NO\n");
        }

        System.out.print(out);
    }

    private static boolean exists(long n) {

        // try depths
        for (int depth = 2; depth <= 60; depth++) {

            long left = 2;
            long right = (long) Math.pow(n, 1.0 / depth) + 1;

            while (left <= right) {

                long mid = left + (right - left) / 2;

                long val = series(mid, depth, n);

                if (val == n) return true;

                if (val < n) left = mid + 1;
                else right = mid - 1;
            }
        }

        return false;
    }

    private static long series(long k, int depth, long limit) {

        long sum = 1;
        long term = 1;

        for (int i = 1; i <= depth; i++) {

            if (term > limit / k) return limit + 1;

            term *= k;
            sum += term;

            if (sum > limit) return limit + 1;
        }

        return sum;
    }
}