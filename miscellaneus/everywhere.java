import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Set<Character> uniq = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniq.add(s.charAt(i));
        }

        int need = uniq.size();

        Map<Character, Integer> freq = new HashMap<>();

        int leftIndex = 0;
        int have = 0;
        int bestLen = n;

        for (int rightIndex = 0; rightIndex < n; rightIndex++) {

            char ch = s.charAt(rightIndex);

            int count = freq.getOrDefault(ch, 0);
            count++;
            freq.put(ch, count);

            if (count == 1) {
                have++;
            }

            while (have == need) {

                int curLen = rightIndex - leftIndex + 1;
                if (curLen < bestLen) {
                    bestLen = curLen;
                }

                char leftChar = s.charAt(leftIndex);

                int leftCount = freq.get(leftChar);
                leftCount--;

                if (leftCount == 0) {
                    freq.remove(leftChar);
                    have--;
                } else {
                    freq.put(leftChar, leftCount);
                }

                leftIndex++;
            }
        }

        System.out.println(bestLen);
    }
}