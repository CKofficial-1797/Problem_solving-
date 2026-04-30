import java.io.*;
import java.util.*;

public class Main {

    static double c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Double.parseDouble(br.readLine());

        double left = 0.0;
        double right = c;

        for (int step = 0; step < 100; step++) {
            double mid = (left + right) / 2.0;

            if (value(mid) >= c) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.printf("%.9f", right);
    }

    static double value(double x) {
        return x * x + Math.sqrt(x);
    }
}