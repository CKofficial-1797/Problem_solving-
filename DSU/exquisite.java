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

        long unionAndCount(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return 0;

            if (size[pa] < size[pb]) {
                int t = pa;
                pa = pb;
                pb = t;
            }

            long pairs = 1L * size[pa] * size[pb];

            parent[pb] = pa;
            size[pa] += size[pb];

            return pairs;
        }
    }

    static class Edge {
        int leftIndex;
        int weight;

        Edge(int li, int w) {
            leftIndex = li;
            weight = w;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if (n == 1) {
                out.append('\n');
                continue;
            }

            Edge[] edges = new Edge[n];

            for (int i = 1; i < n; i++) {
                int diff = Math.abs(arr[i] - arr[i + 1]);
                edges[i] = new Edge(i, diff);
            }

            Arrays.sort(edges, 1, n, (a, b) -> b.weight - a.weight);

            DSU dsu = new DSU(n);

            long[] ans = new long[n];

            long currentPairs = 0;

            int ptr = 1;

            for (int k = n - 1; k >= 1; k--) {

                while (ptr < n && edges[ptr].weight >= k) {

                    int u = edges[ptr].leftIndex;
                    int v = u + 1;

                    currentPairs += dsu.unionAndCount(u, v);

                    ptr++;
                }

                ans[k] = currentPairs;
            }

            for (int k = 1; k <= n - 1; k++) {
                out.append(ans[k]);
                if (k < n - 1) out.append(' ');
            }

            out.append('\n');
        }

        System.out.print(out);
    }
}