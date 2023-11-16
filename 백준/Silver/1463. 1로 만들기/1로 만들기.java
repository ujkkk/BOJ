
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
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
		int [] dp = new int[N+1];
		
		if(N==1) {
			bw.write(0+"\n");
		}
		else if(N==2 || N== 3) {
			bw.write(1+"\n");
		}
		else {
			dp[1] = 0;
			dp[2] = 1;
			dp[3] = 1;
			for(int i=4; i<=N; i++) {
				if(i%2 ==0 && i%3 == 0) {
					dp[i] = Math.min(dp[i/2], dp[i/3]);
					dp[i] = Math.min(dp[i], dp[i-1])+1;
					continue;
				}
				else if(i%2 == 0) {
					dp[i] = Math.min(dp[i/2], dp[i-1])+1;
					continue;
				}
				else if(i%3 == 0) {
					dp[i] = Math.min(dp[i/3], dp[i-1])+1;
					continue;
				}
				else
					dp[i] = dp[i-1]+1;
			}
			
			bw.write(dp[N]+"\n");
		}
		
		
		bw.flush();
		
		bw.close();
		br.close();
	}



}


