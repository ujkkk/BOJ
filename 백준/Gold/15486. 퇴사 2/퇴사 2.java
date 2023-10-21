import java.io.*;
import java.util.StringTokenizer;
public class Main {

    static BufferedReader br;
    static BufferedWriter bw ;

    static int [] period;
    static int [] cost;
    static int [] dp;
    static int N;
    public static void main(String [] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();
        solution();
        bw.write(dp[0]+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    public static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        period = new int[N+2];
        cost = new int[N+2];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void solution() {
        for(int i= N-1; i>=0; i--) {
            int j = i+period[i];
            if(j > N){
                dp[i] = dp[i+1];
            }
            else{
                dp[i] = Math.max(dp[i+1], dp[j] + cost[i]);
            }
        }
    }


}
