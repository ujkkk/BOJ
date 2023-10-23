import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static long [][] dp;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new long[30][30];
        for(int i=0; i<dp.length; i++){
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for(int i=2; i<30; i++){
            for(int j=1; j<30; j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            bw.write(dp[M][N] +"\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

   
}
