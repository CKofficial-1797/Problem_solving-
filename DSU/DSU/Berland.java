import java.io.*;
import java.util.*;

public class Main {

    static class DSU {

        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }

        boolean union(int u, int v) {

            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return false;

            parent[pv] = pu;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        DSU dsu = new DSU(n);

        List<int[]> redundant =
            new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {

            StringTokenizer st =
                new StringTokenizer(br.readLine());

            int u =
                Integer.parseInt(st.nextToken());

            int v =
                Integer.parseInt(st.nextToken());

            if (!dsu.union(u, v)) {
                redundant.add(new int[]{u, v});
            }
        }

        // collect component roots
        Set<Integer> roots =
            new HashSet<>();

        for (int i = 1; i <= n; i++) {
            roots.add(dsu.find(i));
        }

        List<Integer> comps =
            new ArrayList<>(roots);

        int operations =
            comps.size() - 1;

        System.out.println(operations);

        for (int i = 0; i < operations; i++) {

            int[] edge =
                redundant.get(i);

            int u = edge[0];
            int v = edge[1];

            int a = comps.get(i);
            int b = comps.get(i + 1);

            System.out.println(
                u + " " + v + " " + a + " " + b
            );
        }
    }
}