import java.util.*;
import java.lang.*;
import java.io.*;

public class M
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        coins = new int[n];
         st= new StringTokenizer(br.readLine());
        for(int i =0 ; i<n ; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coins);
        int ans = f(n-1 , x);
        System.out.println(ans == L ?-1 : ans);
	}
	private static final int L = 1_000_000_000;
	private static int[]coins;
	private static int f(int id, int sum){
	    if(sum<=0){
	        if(sum==0) return 0;
	        return L;
	    }
	    if(id<0)return L;
	    int take = 1+ Math.min(f(id,sum-coins[id]),f(id-1,sum-coins[id]));
	    return Math.min(take , f(id-1,sum));
	}   
}
