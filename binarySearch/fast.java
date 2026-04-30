import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        n = fs.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        Arrays.sort(arr);

        int q = fs.nextInt();

        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            int leftVal = fs.nextInt();
            int rightVal = fs.nextInt();

            int leftIndex = lowerBound(leftVal);
            int rightIndex = upperBound(rightVal);

            out.append(rightIndex - leftIndex).append(' ');
        }

        System.out.print(out);
    }

    static int lowerBound(int val) {
        int leftIndex = 0;
        int rightIndex = n;

        while (leftIndex < rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            if (arr[mid] >= val) {
                rightIndex = mid;
            } else {
                leftIndex = mid + 1;
            }
        }

        return leftIndex;
    }

    static int upperBound(int val) {
        int leftIndex = 0;
        int rightIndex = n;

        while (leftIndex < rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;

            if (arr[mid] > val) {
                rightIndex = mid;
            } else {
                leftIndex = mid + 1;
            }
        }

        return leftIndex;
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