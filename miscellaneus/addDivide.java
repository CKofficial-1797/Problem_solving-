import java.io.*;
import java.util.*;

public class Main {

    private static int countDivisions(long a, long b) {
        int steps = 0;

        while (a > 0) {
            a /= b;
            steps++;
        }

        return steps;
    }

    private static int solveCase(long a, long b) {

        int best = Integer.MAX_VALUE;

        int start = 0;
        if (b == 1) {
            start = 1;
        }

        for (int inc = start; inc <= 30; inc++) {

            long curB = b + inc;

            int divSteps = countDivisions(a, curB);

            int total = inc + divSteps;

            if (total < best) {
                best = total;
            }
        }

        return best;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            int ans = solveCase(a, b);
            System.out.println(ans);
        }
    }
}