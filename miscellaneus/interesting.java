import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            long result = solve(l, r);
            out.append(result).append('\n');
        }

        System.out.print(out);
    }

    private static long solve(long l, long r) {

        long total = r - l;   // base: one digit per addition

        long p = 10;

        // check trailing 9 patterns: 9, 99, 999, ...
        while (p <= r) {

            long right = (r - 1) / p;
            long left = (l - 1) / p;

            long count = right - left;

            total += count;

            p *= 10;
        }

        return total;
    }
}