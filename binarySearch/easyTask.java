import java.io.*;
import java.util.*;

public class Main {

    static long n, x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        if (n == 1) {
            System.out.println(Math.min(x, y));
            return;
        }

        long first = Math.min(x, y);

        long left = 0;
        long right = (n - 1) * first;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (can(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left + first);
    }

    static boolean can(long time) {
        long copies = time / x + time / y;
        return copies >= n - 1;
    }
}