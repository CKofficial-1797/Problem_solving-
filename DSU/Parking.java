import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
     public static class  DSU{
        int n ;
        // int [] parent ;
        int [] rank ; 
        int [] next;
       
        DSU (int n){
            this.n = n ;          
            // parent = new int[n+1]; 
            next = new int[n+1];
           for(int i =1 ; i<= n; i++){
            // parent[i]=i; 
            next[i] = i;
           }          
            
        }
        // int findP(int u){
        //     if(parent[u]==u)return u;
        //     return parent[u]=findP(parent[u]);
        // }
        int findNext(int u){
            if(next[u]==u) return u;
            return next[u] = findNext(next[u]);
        }
        void update(int u){
            int nxt = (u == n) ? 1 : u + 1;
          next[u] = findNext(nxt);
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         DSU d = new DSU(n);
         StringBuilder sb = new StringBuilder();
         
        for(int i =0 ; i<n ; i++){
           
            int p = Integer.parseInt(st.nextToken());
            // int p = d.findP(pos);
            int pos = d.findNext(p);
            sb.append(pos);
            if(i!=n-1)sb.append(" ");
            d.update(pos);
           
        }
        System.out.println(sb);
	}
}
