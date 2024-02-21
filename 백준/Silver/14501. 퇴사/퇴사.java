
import java.io.*;
import java.util.*;


public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;

		
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int [] dp = new int[N+3];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(i+t <= N) {
				dp[i + t] = Math.max(dp[i+t], dp[i] + p);
			}
				
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
		}
		
		int ans = 0;
		for(int profit : dp) {
			ans = Math.max(ans, profit);
		}
		
		System.out.println(ans);
		
		
	
	}

	
}





