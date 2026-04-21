import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static double[] x;
    static double[] v;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        x = new double[n];
        v = new double[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            v[i] = Double.parseDouble(st.nextToken());
        }

        double left = 0.0;
        double right = 2e9;

        for (int step = 0; step < 100; step++) {

            double mid = (left + right) / 2.0;

            if (can(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.printf("%.7f\n", right);
    }

    private static boolean can(double T) {

        double leftBound = -1e18;
        double rightBound = 1e18;

        for (int i = 0; i < n; i++) {

            double dist = v[i] * T;

            double li = x[i] - dist;
            double ri = x[i] + dist;

            if (li > leftBound) {
                leftBound = li;
            }

            if (ri < rightBound) {
                rightBound = ri;
            }

            if (leftBound > rightBound) {
                return false;
            }
        }

        return true;
    }
}