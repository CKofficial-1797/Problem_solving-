import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long[] pos = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                pos[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(pos);

            for (int i = 0; i < k; i++) {
                int midIndex = (i * n) / k + (n / (2 * k));

                long teleport = pos[midIndex];
                out.append(teleport);

                if (i < k - 1) {
                    out.append(' ');
                }
            }

            out.append('\n');
        }

        System.out.print(out);
    }
}