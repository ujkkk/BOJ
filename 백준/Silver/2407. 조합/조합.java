import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{

    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        BigInteger[][] dp = new BigInteger[101][101];
        for(int i=1; i<=N; i++){
           // dp[i][1] = BigInteger.valueOf(i);
            dp[i][i] = BigInteger.ONE;
        }
        M =Math.min(N-M, M);

        for(int n=1; n<=N;n++){
            for(int m=0; m<=n; m++){
                if(m == 0 || m== n){
                    dp[n][m] = BigInteger.ONE;
                    continue;
                }
                dp[n][m] =  dp[n-1][m-1].add(dp[n-1][m]);
            }
        }

        bw.write(dp[N][M] +"\n");
        bw.flush();

        bw.close();
        br.close();

    }
}