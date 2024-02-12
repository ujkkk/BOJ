import java.io.*;

import java.util.*;

public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;
	
	static int [] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		N = Integer.parseInt(br.readLine());	
		dp = new int[N*3+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		
		for(int i=2; i<=N; i++) {
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
		}
		System.out.print(dp[N]);
	
	
	}
		
}



