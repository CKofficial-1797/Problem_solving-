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
        // int ans = f(n-1 , x);
        int[] dp = new int[x+1];
        Arrays.fill(dp,L);
        dp[0]=0;
        for(int i =n-1; i>=0 ; i--){
            int[] curr = new int[x+1];
            Arrays.fill(curr,L);
            curr[0]=0;
            for(int sum = 1 ; sum<= x; sum++){
                if(sum-coins[i]<0)continue;
                int take = 1+ Math.min(curr[sum-coins[i]] ,dp[sum-coins[i]]);
                curr[sum] = Math.min(take , dp[sum]);
            }
            dp=curr;
        }
        System.out.println(dp[x] == L ?-1 : dp[x]);
	}
	private static final int L = 1_000_000_000;
	private static int[]coins;
// 	private static int f(int id, int sum){
// 	    if(sum<=0){
// 	        if(sum==0) return 0;
// 	        return L;
// 	    }
// 	    if(id<0)return L;
// 	    int take = 1+ Math.min(f(id,sum-coins[id]),f(id-1,sum-coins[id]));
// 	    return Math.min(take , f(id-1,sum));
// 	}   
}
