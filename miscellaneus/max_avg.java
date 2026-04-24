import java.io.*;
import java.util.*;

public class Main {

    static int n, d;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            minVal = Math.min(minVal, arr[i]);
            maxVal = Math.max(maxVal, arr[i]);
        }

        double low = minVal;
        double high = maxVal;

        for (int iter = 0; iter < 60; iter++) {

            double mid = (low + high) / 2.0;

            if (possible(mid))
                low = mid;
            else
                high = mid;
        }

        printSegment(low);
    }

    private static boolean possible(double avg) {

        double[] pref = new double[n + 1];

        for (int i = 1; i <= n; i++)
            pref[i] = pref[i - 1] + arr[i - 1] - avg;

        double minPref = 0;

        for (int i = d; i <= n; i++) {

            if (pref[i] - minPref >= 0)
                return true;

            minPref = Math.min(minPref, pref[i - d + 1]);
        }

        return false;
    }

    private static void printSegment(double avg) {

        double[] pref = new double[n + 1];

        for (int i = 1; i <= n; i++)
            pref[i] = pref[i - 1] + arr[i - 1] - avg;

        double minPref = 0;
        int minIndex = 0;

        for (int i = d; i <= n; i++) {

            if (pref[i] - minPref >= 0) {
                System.out.println((minIndex + 1) + " " + i);
                return;
            }

            if (pref[i - d + 1] < minPref) {
                minPref = pref[i - d + 1];
                minIndex = i - d + 1;
            }
        }
    }
}