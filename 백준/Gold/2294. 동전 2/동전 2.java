import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long dp [] = new long[100001];
        for(int i=0; i<=k; i++){
            dp[i] = Long.MAX_VALUE-100001;
        }
        dp[0] = 0;
        for(int i=0; i<n; i++){
            int coin = Integer.parseInt(br.readLine());
            dp[coin]=1;
            for(int j=coin; j<=k; j++){
                dp[j] = Math.min(dp[j], dp[j-coin]+1);
            }

        }
        if(dp[k] >= Long.MAX_VALUE -100001 || dp[k]<0)
            bw.write(Integer.toString(-1));
        else
            bw.write(dp[k]+"\n");
        bw.flush();
    }

}
