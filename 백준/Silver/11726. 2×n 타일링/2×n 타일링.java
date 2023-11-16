import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		long [] dp = new long[N+2];
		
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		bw.write(Long.toString(dp[N]));	
		bw.flush();
		
		bw.close();
		br.close();
	}
}


