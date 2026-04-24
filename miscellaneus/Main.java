import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        pos = new int[n];
        int id =0;
       
        while(n-->0){
             pos[id] = Integer.parseInt(st.nextToken());
             
             id++;
        }
        int low = 0 ;
        int high = pos[id-1] - pos[0];
        int best = -1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(check(mid,k)){
                best = mid ;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        System.out.println(best);
	}
	private static int[] pos;
	private static  boolean check(int gap,int k){
	    int count = 1;        // first cow placed
        int lastPos = pos[0];

        for (int i = 1; i < pos.length; i++) {

            if (pos[i] - lastPos >= gap) {

                count++;
                lastPos = pos[i];

                if (count == k)
                    return true;
            }
        }

        return false;
	}
}
