import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            
            int ml = 0;
            for (int i = 0; i < a.length(); i++) {
                for (int j = i + 1; j <= a.length(); j++) {
                    String sub = a.substring(i, j);
                    if (b.contains(sub)) {
                        ml = Math.max(ml, sub.length());
                    }
                }
            }
            
            int ans = a.length() + b.length() - 2 * ml;
            System.out.println(ans);
        }
    }
}