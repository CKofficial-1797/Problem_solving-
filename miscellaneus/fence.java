import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] h = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int curSum = 0;

        for (int i = 0; i < k; i++) {
            curSum += h[i];
        }

        int minSum = curSum;
        int bestIndex = 0;

        for (int r = k; r < n; r++) {
            curSum += h[r];
            curSum -= h[r - k];

            if (curSum < minSum) {
                minSum = curSum;
                bestIndex = r - k + 1;
            }
        }

        System.out.println(bestIndex + 1);
    }
}