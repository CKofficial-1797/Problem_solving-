import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long x1, y1, x2, y2;
    static int n;
    static String s;

    static long[] px; // prefix displacement in x
    static long[] py; // prefix displacement in y

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());

        n = Integer.parseInt(br.readLine());
        s = br.readLine();

        buildPrefix();

        long left = 0;
        long right = (long) 2e14;
        long ans = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canReach(mid)) {
                ans = mid;
                right = mid - 1; // try smaller days
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static void buildPrefix() {

        px = new long[n + 1];
        py = new long[n + 1];

        for (int i = 0; i < n; i++) {

            px[i + 1] = px[i];
            py[i + 1] = py[i];

            char c = s.charAt(i);

            if (c == 'U') py[i + 1]++;
            else if (c == 'D') py[i + 1]--;
            else if (c == 'L') px[i + 1]--;
            else if (c == 'R') px[i + 1]++;
        }
    }

    private static boolean canReach(long days) {

        long cycles = days / n;
        int rem = (int) (days % n);

        long windX = cycles * px[n] + px[rem];
        long windY = cycles * py[n] + py[rem];

        long curX = x1 + windX;
        long curY = y1 + windY;

        long dist = Math.abs(x2 - curX) + Math.abs(y2 - curY);

        return dist <= days;
    }
}