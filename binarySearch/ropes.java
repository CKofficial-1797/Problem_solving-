import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > maxLen) maxLen = arr[i];
        }

        double left = 0.0;
        double right = maxLen;

        for (int step = 0; step < 100; step++) {
            double mid = (left + right) / 2.0;

            if (canMake(mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.printf("%.6f", left);
    }

    static boolean canMake(double len) {
        if (len == 0.0) return true;

        int pieces = 0;

        for (int i = 0; i < n; i++) {
            pieces += (int) (arr[i] / len);
            if (pieces >= k) return true;
        }

        return false;
    }
}