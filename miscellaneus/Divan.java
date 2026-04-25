import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = null;
        
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][2];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = i + 1;
            }
            
            Arrays.sort(arr, (x, y) -> Integer.compare(y[0], x[0]));
            
            int[] ans = new int[n + 1];
            long cost = 0;
            int d = 1;
            
            for (int i = 0; i < n; i++) {
                int id = arr[i][1];
                long v = arr[i][0];
                int pos = (i % 2 == 0) ? d : -d;
                ans[id] = pos;
                cost += 2L * v * d;
                if (i % 2 != 0) d++;
            }
            
            pw.println(cost);
            for (int i = 0; i <= n; i++) {
                pw.print(ans[i] + (i == n ? "" : " "));
            }
            pw.println();
        }
        pw.flush();
    }
}