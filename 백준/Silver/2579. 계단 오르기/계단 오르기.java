import java.io.*;

public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;
	
	static int [] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		int [] A = new int[N+3];
		for(int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		int [] dp = new int [N+3];
		dp[0]=0;
		dp[1] = A[1];
		dp[2] = A[1] + A[2];
		
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + A[i-1], dp[i-2]) + A[i];
		}
		
		System.out.print(dp[N]);
	
	
	}
		
}



