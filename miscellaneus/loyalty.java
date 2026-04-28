import java.io.*;
import java.util.*;

public class Main {

    private static class Result {
        long bonus;
        int[] order;

        Result(long b, int[] o) {
            bonus = b;
            order = o;
        }
    }

    private static Result solveCase(int[] arr, int X) {

        Arrays.sort(arr);
        reverse(arr);

        long sum = 0;
        long total = 0;

        for (int p : arr) {

            long oldLevel = sum / X;

            sum += p;

            long newLevel = sum / X;

            if (newLevel > oldLevel) {
                total += p;
            }
        }

        return new Result(total, arr);
    }

    private static void reverse(int[] a) {

        int li = 0;
        int ri = a.length - 1;

        while (li < ri) {
            int t = a[li];
            a[li] = a[ri];
            a[ri] = t;
            li++;
            ri--;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Result res = solveCase(arr, X);

            System.out.println(res.bonus);

            StringBuilder sb = new StringBuilder();

            for (int v : res.order) {
                sb.append(v).append(' ');
            }

            System.out.println(sb.toString().trim());
        }
    }
}