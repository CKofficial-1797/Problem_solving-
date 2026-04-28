import java.io.*;
import java.util.*;

public class Main {

    private static long countAtMost(int[] arr, int K, int lenLimit) {

        if (K < 0 || lenLimit <= 0) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int distinct = 0;

        long total = 0;

        for (int right = 0; right < arr.length; right++) {

            int val = arr[right];
            int f = freq.getOrDefault(val, 0);

            if (f == 0) {
                distinct++;
            }

            freq.put(val, f + 1);

            while (distinct > K) {

                int lv = arr[left];
                int lf = freq.get(lv) - 1;

                if (lf == 0) {
                    freq.remove(lv);
                    distinct--;
                } else {
                    freq.put(lv, lf);
                }

                left++;
            }

            int minLeftByLen = right - lenLimit + 1;

            int start = Math.max(left, minLeftByLen);

            if (start <= right) {
                total += (right - start + 1);
            }
        }

        return total;
    }

    private static long solveCase(int[] arr, int k, int l, int r) {

        long a = countAtMost(arr, k, r);
        long b = countAtMost(arr, k, l - 1);

        long c = countAtMost(arr, k - 1, r);
        long d = countAtMost(arr, k - 1, l - 1);

        return a - b - c + d;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = solveCase(arr, k, l, r);

            System.out.println(ans);
        }
    }
}