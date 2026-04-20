import java.util.*;
import java.lang.*;
import java.io.*;

public class main 
{
    public static class dsu{
        int n ;
        int boss[];
        int depth[];
       
        dsu(int n ){
            this.n = n;
            boss = new int[n+1];
            depth = new int[n+1];

            for(int i =1 ; i<=n ; i++){
                boss[i]=i;
            
            }
        }
        // there is no compression we have to carry the depth eith each node 
        //assuming u subordinated only to v directly 
        // int findP(int u){
        //     if(boss[u]!=u) return boss[u] =findP(boss[u]);
        //     return u;
        // }
        
        int findDepth(int u){

            if(boss[u] == u)
                return depth[u];

            int parent = boss[u];

            depth[u] += findDepth(parent);

            boss[u] = boss[parent];

            return depth[u];
        }

        void union(int u, int v){

            boss[u] = v;

            depth[u] = 1;
        }
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m  = sc.nextInt();
		dsu d = new  dsu(n);
		while(m-->0){
		    int op = sc.nextInt();
		    if(op==1){
		        int u = sc.nextInt();
		        int v = sc.nextInt();
		        d.union(u,v);
		    }
		    else {
		        int u = sc.nextInt();
		        System.out.println(d.findDepth(u));
		    }
		}

	}
}
