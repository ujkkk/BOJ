
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long sum = 0;
		int max = -1;
		int [] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
			max = Math.max(max, nums[i]);
		}
		
		int budget = Integer.parseInt(br.readLine());
		
		int low = budget/N;
		int high = max;
		int mid =0;
		
		while(low <= high) {
			mid = (low+high)/2;
			long curSum = 0;
			
			for(int request : nums) {
				if(request > mid) {
					curSum += mid;
					continue;
				}
				curSum += request;
			}
			
			if(curSum > budget) {
				high = mid-1;
			}
			else if(curSum <= budget){
				low = mid+1;
			}
		}
		
		bw.write(high+"");
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}
