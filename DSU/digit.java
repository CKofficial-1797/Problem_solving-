import java.io.*;
import java.util.*;

public class digit {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int q = Integer.parseInt(br.readLine());

        while (q-- > 0) {

            long k = Long.parseLong(br.readLine());

            int digitLen = 1;
            long count = 9;
            long start = 1;

            // find block
            while (k > digitLen * count) {
                k -= digitLen * count;

                digitLen++;
                count *= 10;
                start *= 10;
            }

            // find number
            long index = (k - 1) / digitLen;
            long number = start + index;

            // find digit
            int digitIndex = (int) ((k - 1) % digitLen);

            char ans = Long.toString(number).charAt(digitIndex);

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }
}