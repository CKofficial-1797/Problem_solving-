import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
     public static class  DSU{
        int n ;
        int [] parent ;
        int [] size ;
        // Set<Integer>unique_parents;
        int comp;
        int maxSize;
        DSU (int n){
            this.n = n ;
            size = new int[n+1];
            parent = new int[n+1];
            // unique_parents = new HashSet<>(); 
            comp =n;
           for(int i =1 ; i<= n; i++){
            parent[i]=i;
            // unique_parents.add(i);
           }
            Arrays.fill(size ,1);
            
            maxSize = 1;
        }
        int findP(int u){
            if(parent[u]==u)return u;
            return parent[u]=findP(parent[u]);
        }
        void connect(int pu, int pv){
            // int pu = findP(u);
            // int pv = findP(v);
            // int[] out = new int[2];
            // if(pu == pv) return out;//first check in the query itself hen join 
            if(size[pu]>=size[pv]){
                parent[pv]=pu;
                size[pu]+=size[pv];
                // unique_parents.remove(pv);
                
                maxSize = Math.max(maxSize , size[pu]);
            }else{
                parent[pu] = pv;
                size[pv]+=size[pu];

                // unique_parents.remove(pu);
                maxSize = Math.max(maxSize , size[pv]);
            }
            // out[0] = unique_parents.size();
            // out[1] = maxSize;
            // return out;
            comp--;
        }

    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		//   Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        DSU d = new DSU(n);
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<m ; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int pu = d.findP(u);
                int pv = d.findP(v);
                if(pu!=pv){
                    d.connect(pu,pv);
                }
                sb.append(d.comp).append(" ").append(d.maxSize).append("\n");
               
        }
        // input
        System.out.print(sb);
        // logic

        // sc.close();

	}
}
