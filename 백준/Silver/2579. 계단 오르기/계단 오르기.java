import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int nums [] = new int[301];
        int [] dp = new int[301];
        for(int i =1; i<=N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = nums[1];
        dp[2] = nums[1] + nums[2];

        for(int i=3; i<= N; i++){
            dp[i] = Math.max(dp[i-3] + nums[i-1],dp[i-2]) + nums[i];
        }
        bw.write(dp[N]+"\n");

        bw.flush();

        bw.close();
        br.close();
    }


}

