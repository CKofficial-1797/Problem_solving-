import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
     static int countFactor(long val, int base) {
        int cnt = 0;
        while (val % base == 0) {
            val /= base;
            cnt++;
        }
        return cnt;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int[] two = new int[n];
        int[] five = new int[n];

        int maxFive = 0;

        for (int i = 0; i < n; i++) {

            long v = arr[i];

            two[i] = countFactor(v, 2);
            five[i] = countFactor(v, 5);

            maxFive += five[i];
        }

        int[][] dp = new int[k + 1][maxFive + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 0;
        
        for(int i =0 ; i<n ; i++){
            int f = five[i];
            int t = two[i];
            for(int cnt = k ; cnt>=1; cnt--){
                for(int curf = maxFive ; curf>=f ; curf--){
                    if(dp[cnt-1][curf-f]!=-1){
                       dp[cnt][curf] = Math.max(dp[cnt][curf] ,
                       dp[cnt-1][curf-f]+t);
                    }
                }
            }
            
        }
        int ans =0;
        for(int i = 0 ; i<=maxFive ; i++ ){
            if(dp[k][i]==-1)continue;
            int  zero = Math.min(dp[k][i] , i);
            ans = Math.max(ans,zero);
        }
        System.out.println(ans);
	}
}
