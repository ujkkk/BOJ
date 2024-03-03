import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long [] dp = new long[N+1];

        dp[0] = 1;
        for(int i=1; i<=N; i++){
            for(int j=i-1; j>=0; j--){
                dp[i] += (dp[i-1-j]*dp[j]);
            }
        }
        bw.write(dp[N] +"");
        bw.flush();

    }








}

