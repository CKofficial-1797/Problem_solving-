import java.io.*;
import java.util.*;

public class Main {

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
                int t = pa;
                pa = pb;
                pb = t;
            }

            parent[pb] = pa;
            size[pa] += size[pb];
        }

        boolean same(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        DSU d1 = new DSU(n);
        DSU d2 = new DSU(n);

        for (int i = 0; i < m1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            d1.union(u, v);
        }

        for (int i = 0; i < m2; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            d2.union(u, v);
        }

        StringBuilder out = new StringBuilder();
        int count = 0;

        for (int u = 1; u <= n; u++) {
            for (int v = u + 1; v <= n; v++) {

                if (!d1.same(u, v) && !d2.same(u, v)) {

                    d1.union(u, v);
                    d2.union(u, v);

                    count++;
                    out.append(u).append(" ").append(v).append('\n');
                }
            }
        }

        System.out.println(count);
        System.out.print(out);
    }
}