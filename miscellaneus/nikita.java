import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();

        int[] prefA = new int[n + 1];
        int[] prefB = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefA[i + 1] = prefA[i];
            prefB[i + 1] = prefB[i];

            if (s.charAt(i) == 'a') {
                prefA[i + 1]++;
            } else {
                prefB[i + 1]++;
            }
        }

        int[] sufA = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            sufA[i] = sufA[i + 1];
            if (s.charAt(i) == 'a') {
                sufA[i]++;
            }
        }

        int bestLeft = 0;
        int ans = 0;

        for (int j = 0; j <= n; j++) {
            bestLeft = Math.max(bestLeft, prefA[j] - prefB[j]);

            int cur = bestLeft + prefB[j] + sufA[j];

            if (cur > ans) {
                ans = cur;
            }
        }

        System.out.println(ans);
    }
}