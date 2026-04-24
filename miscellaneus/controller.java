import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int plus = 0;
        int minus = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '+')
                plus++;
            else
                minus++;
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder ans = new StringBuilder();

        while (q-- > 0) {

            StringTokenizer st =
                new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (a == b) {

                if (plus == minus)
                    ans.append("YES\n");
                else
                    ans.append("NO\n");

                continue;
            }

            long d = a - b;
            long k = minus - plus;

            long numerator = b * k;

            if (numerator % d != 0) {
                ans.append("NO\n");
                continue;
            }

            long t = numerator / d;

            if (t >= -minus && t <= plus)
                ans.append("YES\n");
            else
                ans.append("NO\n");
        }

        System.out.print(ans);
    }
}