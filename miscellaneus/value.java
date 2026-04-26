import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[k + 1][k + 1];
        dp[0][0] = true;
        
        for(int coin : coins){
            for(int s = k ; s>=0 ; s--){
                for(int x = 0 ; x<=s ; x++){
                    if(!dp[s][x]) continue;
                    if(s+coin >k)continue;
                    dp[s+coin][x] = true;
                    if(x+coin <= k){
                        dp[s+coin][x+coin] =true;             
                    }
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();

        for (int x = 0; x <= k; x++) {
            if (dp[k][x]) {
                ans.add(x);
            }
        }

        System.out.println(ans.size());

        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(ans.get(i));
        }
	}

}
