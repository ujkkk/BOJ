
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static BufferedWriter bw;
	public static BufferedReader br;
	
	static int [] dp;
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		int rgb [][] = new int[N+1][3];
		int dp [][] = new int[N+1][3];
		
		StringTokenizer st;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][0] = rgb[1][0];
		dp[1][1] = rgb[1][1];
		dp[1][2] = rgb[1][2];
		
		for(int i=2; i<=N; i++) {
			
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+ rgb[i][0] ;
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+ rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+ rgb[i][2];	
			
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0; i<3; i++) {
			result = Math.min(result, dp[N][i]);
		}
		
		bw.write(result+"");
		bw.flush();
	}
		
}



