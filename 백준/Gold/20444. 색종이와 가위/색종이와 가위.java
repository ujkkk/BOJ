

import java.io.*;
import java.util.Arrays;


public class Main {
	
    public static void main(String[] args) throws IOException {
    	
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
       String [] nums = br.readLine().split(" ");
       long n = Long.parseLong(nums[0]);
       long k = Long.parseLong(nums[1]);
       
       long min = 0;//차이가 많이 없을 때 많이 잘라
       long max = n; // 차이가 클 때 적게 잘라
       
       while(min < max) {
    	   long mid = (min+max)/2;
    	   
    	   long curK = (mid+1)*(n-mid+1);
    	   
    	   // 원하는 개수보다 많이 잘라질 때 
    	   if(curK > k) {
    		  max = mid;
    	   }
    	   else if(curK == k) {
    		   max = n;
    		   System.out.println("YES");
    		   return;
    	   }
    	   else {
    		   min = mid +1;
    	   }
       }

       bw.write("NO");

       
            
       bw.flush();
       bw.close();
       br.close();

    }
}