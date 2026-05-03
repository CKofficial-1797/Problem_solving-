import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        StringTokenizer st = new StringTokenizer(line);
        int t = Integer.parseInt(st.nextToken());
        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            long li = 1;
            long rb = m;
            long ans = m;

            while (li <= rb) {
                long mid = li + (rb - li) / 2;
                long perRow = (m / (mid + 1)) * mid + (m % (mid + 1));
                
                if (n * perRow >= k) {
                    ans = mid;
                    rb = mid - 1;
                } else {
                    li = mid + 1;
                }
            }
            out.append(ans).append('\n');
        }
        System.out.print(out);
    }
}