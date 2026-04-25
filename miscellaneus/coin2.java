import java.util.*;
import java.lang.*;
import java.io.*;

public class coin2
{   	private static int mod = 1_000_000_007;
	public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st  = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int x = Integer.parseInt(st.nextToken());
	    int[] coins  = new int[n];
	    st = new StringTokenizer(br.readLine());
	    for(int i =0  ; i<n ; i++){
	        
	        coins[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(coins);
	    int ans = Integer.MAX_VALUE;
	    for(int i = n-1 ; i>=0 ; i--){
	        int sum = x;
	        int count =0;
	        for(int j = i; j>=0 ; j--){
	            
	            if(sum>=coins[j]){
	                count += sum/coins[j];
	                sum = sum%coins[j];
	                if(sum==0)break;
	            }
	            
	        }
	        if(sum==0) ans = Math.min(ans, count);
	    }
	    System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
        
	}
	
// 	int f(int sum){
// 	    if(sum<=0){
// 	        if(sum==0)return 1;
// 	        return 0;
// 	    }
// 	    int cnt = 0;
	    
// 	    for(int i =0 ; i<n ; i++){
// 	        cnt = (cnt + f(sum-coins[i]))%mod;
// 	    }
// 	    return cnt ;
// 	}
}

