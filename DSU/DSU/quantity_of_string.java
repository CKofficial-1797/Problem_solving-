import java.io.*;
import java.util.*;

public class Main {

    static final long MOD = 1_000_000_007L;

   
    static class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return;

            if (size[pa] < size[pb]) {
                int tmp = pa;
                pa = pb;
                pb = tmp;
            }

            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    
    static long power(long base, int exp) {
        long res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String[] parts = br.readLine().split(" ");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int k = Integer.parseInt(parts[2]);

        DSU dsu = new DSU(n);

       
        for (int start = 1; start <= n - k + 1; start++) {

            int left = 0;
            int right = k - 1;

            while (left < right) {

                int u = start + left;
                int v = start + right;

                dsu.union(u, v);

                left++;
                right--;
            }
        }

       
        HashSet<Integer> comp = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            comp.add(dsu.find(i));
        }

        int groups = comp.size();

        long ans = power(m, groups);

        System.out.println(ans);
    }
}