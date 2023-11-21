
import java.io.*;
import java.util.*;


class Main
{

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long [][] dp = new long[N+1][10];
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=N; i++){
            for(int j =0; j <=9; j++){
                for(int k=j; k<=9; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        long result = 0;
        for(long value : dp[N]){
            result += value;
        }


        bw.write(result%10007 +"\n");
        bw.flush();

        bw.close();
        br.close();

    }

}

