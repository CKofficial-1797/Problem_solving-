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

        int compSize(int x) {
            return size[find(x)];
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            if (k == 0) continue;

            int first =
                    Integer.parseInt(st.nextToken());

            for (int j = 1; j < k; j++) {

                int member =
                        Integer.parseInt(st.nextToken());

                dsu.union(first, member);
            }
        }

        StringBuilder out = new StringBuilder();

        for (int i = 1; i <= n; i++) {

            out.append(dsu.compSize(i));

            if (i < n) out.append(" ");
        }

        System.out.println(out);
    }
}