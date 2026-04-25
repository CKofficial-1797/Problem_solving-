import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] a;
    static int[] b;
    static double[] val;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =
            new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[n];
        val = new double[n];

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        double low = 0.0;
        double high = 100000.0;

        for (int iter = 0; iter < 60; iter++) {

            double mid = (low + high) / 2.0;

            if (possible(mid))
                low = mid;
            else
                high = mid;
        }

        System.out.printf("%.10f\n", low);
    }

    private static boolean possible(double mid) {

        for (int i = 0; i < n; i++)
            val[i] = a[i] - mid * b[i];

        Arrays.sort(val);

        double sum = 0;

        for (int i = n - 1; i >= n - k; i--)
            sum += val[i];

        return sum >= 0;
    }
}