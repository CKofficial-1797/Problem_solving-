import java.util.*;
import java.io.*;

public class array_partition {

    private static boolean canSplit(int[] arr, int k, long limit) {

        int parts = 1;
        long current = 0;

        for (int val : arr) {

            if (current + val <= limit) {
                current += val;
            } else {
                parts++;
                current = val;

                if (parts > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        long left = 0;
        long right = 0;

        for (int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());

            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        long answer = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canSplit(arr, k, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}