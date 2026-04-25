import java.util.*;
import java.lang.*;
import java.io.*;

public class dice
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int sum =1 ; sum<=n ; sum++){
            for(int i = 1 ; i<=6 ; i++){
                if(sum-i>= 0){
                    dp[sum]=(dp[sum-i] + dp[sum])%mod;
                }
            }
        }
        System.out.println(dp[n]);
	}
	private static int mod = 1_000_000_007;
// 	private static int f(int n){
// 	    if(n<=0){
// 	        if(n==0)return 1;
// 	        return 0;
// 	    }
// 	    int cnt =0 ;
// 	    for(int i =1 ; i<=6; i++){
// 	        cnt = (cnt + f(n-i))%mod;
// 	    }
// 	    return cnt ;
	    
// 	}
	//TC - 6^n -- imposssible 
	//by memoization - o(n)
}
