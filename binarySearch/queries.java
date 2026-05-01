import java.io.*;
import java.util.*;

public class Main {

    static int upperBound(int[] arr, int key) {
        int leftIndex = 0;
        int rightBound = arr.length;

        while (leftIndex < rightBound) {
            int midIndex = leftIndex + (rightBound - leftIndex) / 2;

            if (arr[midIndex] <= key) {
                leftIndex = midIndex + 1;
            } else {
                rightBound = midIndex;
            }
        }

        return leftIndex;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int count = upperBound(a, b[i]);
            out.append(count);

            if (i < m - 1) {
                out.append(' ');
            }
        }

        System.out.print(out);
    }
}