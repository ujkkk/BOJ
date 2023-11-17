import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        Point [] dp = new Point[41];
        dp[0] = new Point(1,0);
        dp[1] = new Point(0,1);
        dp[2] = new Point(1,1);

        for(int i=3; i<=40; i++){
            dp[i] = new Point(dp[i-1].count0 + dp[i-2].count0,
                    dp[i-1].count1 + dp[i-2].count1);
        }
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n].count0 + " " + dp[n].count1 +"\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }


}

class Point{
    int count0;
    int count1;

    public Point(int count0, int count1){
        this.count0 = count0;
        this.count1 = count1;
    }
}