import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        pos  = new int[n];
        v = new int[n];
        int id =0 ;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(id<n){
            pos[id] = Integer.parseInt(st.nextToken());
            id++;
        }
        id =0;
         st = new StringTokenizer(br.readLine());
        while(id<n){
            v[id] = Integer.parseInt(st.nextToken());
            id++;
        }
        double low = 0;
        double high = 1_000_000_005;
        
        while(high-low >= 1e-6){
            double mid = low +(high-low)/2;
            if(check(mid)){
              high = mid;
            }else{
               low = mid;
            }
        }
        System.out.println(high);
	}
	private static int pos[];
	private static int v[];
	private static  boolean check(double t){
	    int n = pos.length;
	    double start = pos[0] -v[0]*t;
	    double end = pos[0]+v[0]*t;
	    for(int i =1 ; i<n ; i++){
	        double l = pos[i] - v[i] *t;
	        double r = pos[i] + v[i] *t;
	        if(Math.max(start ,l) <= Math.min(end ,r)){
	            start = Math.max(start,l);
	            end = Math.min(end,r);
	        }else {
	            return false;
	        }
	    }
	    return true;
	}
}
