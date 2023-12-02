import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long dp [] = new long[10001];
        long A[] = new long[10001];

        for(int i=1; i<=N; i++){
            A[i] = Long.parseLong(br.readLine());
        }

        dp[1] = A[1];
        dp[2] = A[1]+A[2];
        for(int i=3; i<=N; i++){
            dp[i] =  Math.max(dp[i-1] ,Math.max(dp[i-2]+ A[i],dp[i-3]+A[i-1] + A[i]));
        }
        
        bw.write(dp[N]+"\n");
        bw.flush();
    }
}
