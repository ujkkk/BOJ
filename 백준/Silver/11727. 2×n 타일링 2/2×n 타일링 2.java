import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int dp [] = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=1000; i++){
            if(i%2 == 0){
                dp[i] = (dp[i-2]*3 + dp[i-2]-1)%10007;
                continue;
            }
            dp[i] = (dp[i-1]*2-1)%10007;
        }
        bw.write(dp[N]+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
