import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//9 3(nM)
		//1 2 3 4 5 6 7 8 9
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int nums [] =new int[N];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		int left = -1;
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
			left = Math.max(left, nums[i]);
		}
		
		
		int right = sum;
		
		while(left <= right) {
			int mid = (left+right)/2;
			int curSum = 0;
			int cnt = 0;
			
			for(int i=0; i<N; i++) {
				if(curSum + nums[i] > mid) {
					cnt++;
					curSum =0;
				}
				curSum += nums[i];
			}
			if (curSum != 0) cnt += 1;
			
			if(cnt<= M) {
				right = mid -1;
			}
			else {
				left = mid +1;
			}
			
		}
		bw.write(left+"");
		
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}
