import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i<n ; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        Arrays.sort(arr);
        int l = arr[n/2];
        int r = max+k;
        int best = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            //check if all are less than mid in 0 to n/2-1;
            
            long req = 0;
            for(int i = n/2 ; i<n ; i++){
                if(arr[i]>mid)break;
                req += mid - arr[i];
            }
            if(req<=k){
                best = mid ;
               l = mid+1;
            }else{
                r = mid-1;
            }
        }
        System.out.println(best);
        
	}
}
