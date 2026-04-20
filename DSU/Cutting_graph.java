import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    private static class DSU {
        int n ;
        int parent[];
        int rank[];
        DSU(int n){
            this.n = n;
            parent = new int[n+1];
            rank = new int[n+1];
            for(int i =1 ; i<=n ; i++){
                parent[i] =i;
            }
           
        }
        int findP(int u ){
            if(parent[u]!=u)return parent[u] = findP(parent[u]);
            return u;
        }
        
        void union (int u , int v){
            int pu = findP(u);
            int pv = findP(v);
            if(pu==pv) return;
            if(rank[pu]==rank[pv]) rank[pu]++;
            if(rank[pu]<rank[pv]){
                int t = pu;
                pu = pv;
                pv =t;
            }
            parent[pv]=pu;
            
        }
    }
    public static class Node {
        String op ;
        int u , v;
        Node(String s , int u , int v){
            op = s;
            this.u =u;
            this.v = v;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] edge = new int[m][2];
        for(int i =m-1; i>=0 ; i--){
            st = new StringTokenizer(br.readLine());
            edge[i][0] = Integer.parseInt(st.nextToken());
            edge[i][1] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Node>q = new ArrayList<>();
        while(k-- >0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());
            q.add(new Node(s,u,v));
        }
        DSU d = new DSU(n);
        Collections.reverse(q);
        ArrayList<String>out = new ArrayList<>();
        for(Node node : q){
            if(node.op.equals("cut")){
                d.union(node.u, node.v);
            }
            else{
                int pu = d.findP(node.u);
                int pv = d.findP(node.v);
                out.add(
                    pu==pv ? "YES" : "NO" 
                    );
                
            }
        }
        for(int i =out.size()-1; i>=0 ; i--){
            System.out.println(out.get(i));
        }
        
        
	}
}
