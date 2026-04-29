import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        n = fs.nextInt();
        int q = fs.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int val = fs.nextInt();
            out.append(closestRight(val)).append('\n');
        }

        System.out.print(out);
    }

    static int closestRight(int val) {
        int leftIndex = 0;
        int rightIndex = n - 1;
        int resIndex = n;

        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            if (arr[mid] >= val) {
                resIndex = mid;
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }

        return resIndex + 1;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}