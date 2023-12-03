import java.io.*;
import java.util.*;

public class Main{


    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dp [] = new int[100001];
        for(int i=0; i<n; i++){
            int coin = Integer.parseInt(br.readLine());
            dp[coin]++;
            for(int j=coin; j<=k; j++){
                dp[j] = dp[j] + dp[j-coin];
            }

        }
        bw.write(dp[k]+"\n");
        bw.flush();
    }

}
