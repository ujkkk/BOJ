import java.lang.*;
import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];

        for(int i=0; i<=N; i++){
            dp[i] = i;
        }

        for(int i=1; i<=N; i++){
            for(int j=2; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j] +1);
            }
        }
        bw.write(dp[N] +"");
        bw.flush();

    }








}

