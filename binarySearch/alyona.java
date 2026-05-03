import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        
        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        
        int li = 1;
        int rb = n;
        int ans = 0;
        
        while (li <= rb) {
            int mid = li + (rb - li) / 2;
            if (check(a, mid, h)) {
                ans = mid;
                li = mid + 1;
            } else {
                rb = mid - 1;
            }
        }
        
        System.out.println(ans);
    }
    
    static boolean check(long[] a, int k, long h) {
        long[] cur = new long[k];
        System.arraycopy(a, 0, cur, 0, k);
        Arrays.sort(cur);
        
        long rs = 0;
        for (int i = k - 1; i >= 0; i -= 2) {
            rs += cur[i];
        }
        
        return rs <= h;
    }
}