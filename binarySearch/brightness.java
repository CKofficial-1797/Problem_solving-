import java.io.*;
import java.util.*;

public class Main {

    static long countOn(long n) {
        long root = (long) Math.sqrt(n);
        return n - root;
    }

    static long findMinBulbs(long k) {
        long left = 1;
        long right = k + (long) Math.sqrt(k) + 5;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (countOn(mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            long k = Long.parseLong(br.readLine().trim());
            long ans = findMinBulbs(k);
            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}