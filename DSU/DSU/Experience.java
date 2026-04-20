import java.io.*;
import java.util.*;

public class Main {

    static class DSU {

        int[] parent;
        int[] rank;
        int[] xp;

        DSU(int n) {

            parent = new int[n + 1];
            rank = new int[n + 1];
            xp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int u) {

            if (parent[u] == u)
                return u;

            int p = parent[u];

            parent[u] = find(parent[u]);

            xp[u] += xp[p];

            return parent[u];
        }

        void add(int u, int val) {

            int root = find(u);

            xp[root] += val;
        }

        int get(int u) {

            find(u);

            return xp[u];
        }

        void join(int u, int v) {

            int ru = find(u);
            int rv = find(v);

            if (ru == rv)
                return;

            if (rank[ru] < rank[rv]) {
                int t = ru;
                ru = rv;
                rv = t;
            }

            parent[rv] = ru;

            xp[rv] -= xp[ru];

            if (rank[ru] == rank[rv])
                rank[ru]++;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =
            new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        DSU dsu = new DSU(n);

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {

            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();

            if (op.equals("join")) {

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                dsu.join(u, v);

            }
            else if (op.equals("add")) {

                int u = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());

                dsu.add(u, val);

            }
            else {

                int u = Integer.parseInt(st.nextToken());

                sb.append(dsu.get(u)).append('\n');
            }
        }

        System.out.print(sb);
    }
}