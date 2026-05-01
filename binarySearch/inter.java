import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextInt()) return;
        
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] pref = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pref[i] = pref[i - 1] + in.nextInt();
            }

            int li = 1;
            int rb = n;

            while (li < rb) {
                int pivot = (li + rb) / 2;
                int k = pivot - li + 1;
                
                System.out.print("? " + k);
                for (int i = li; i <= pivot; i++) {
                    System.out.print(" " + i);
                }
                System.out.println();
                System.out.flush();

                long w = in.nextLong();
                long rs = pref[pivot] - pref[li - 1];

                if (w > rs) {
                    rb = pivot;
                } else {
                    li = pivot + 1;
                }
            }
            System.out.println("! " + li);
            System.out.flush();
        }
        in.close();
    }
}