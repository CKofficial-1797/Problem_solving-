import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static double[] x;
    static double[] t;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // int tc = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (tc-- > 0) {

            // n = Integer.parseInt(br.readLine());

            x = new double[n];
            t = new double[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                x[i] = Double.parseDouble(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                t[i] = Double.parseDouble(st.nextToken());
            }

            double leftTime = 0.0;
            double rightTime = 2e9;

            // binary search on minimum time
            for (int step = 0; step < 100; step++) {

                double midTime = (leftTime + rightTime) / 2.0;

                if (canMeet(midTime)) {
                    rightTime = midTime;
                } else {
                    leftTime = midTime;
                }
            }

            double meetPoint = getPoint(rightTime);

            out.append(String.format("%.7f\n", meetPoint));
        }

        System.out.print(out);
    }

    // check if all people can meet within time T
    private static boolean canMeet(double T) {

        double leftBound = -1e18;
        double rightBound = 1e18;

        for (int i = 0; i < n; i++) {

            if (T < t[i]) {
                return false;
            }

            double dist = T - t[i];

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

    // compute final meeting position
    private static double getPoint(double T) {

        double leftBound = -1e18;
        double rightBound = 1e18;

        for (int i = 0; i < n; i++) {

            double dist = T - t[i];

            double li = x[i] - dist;
            double ri = x[i] + dist;

            if (li > leftBound) {
                leftBound = li;
            }

            if (ri < rightBound) {
                rightBound = ri;
            }
        }

        return leftBound; // unique solution guaranteed
    }
}