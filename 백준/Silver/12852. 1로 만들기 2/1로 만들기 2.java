
import java.io.*;
import java.util.*;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static int [] parent;


    public static void main(String[] args) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int dp[] = new int [N+1];
        dp[1] = 0;

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1] +1;
            if(i%2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }
            if(i%3 == 0){
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
        }
        bw.write(dp[N]+"\n");

        int index = N;
        while(true){
            bw.write(index +" ");
            if(index == 1)
                break;
            // 더 작은 것 찾기
            int next = index-1;
            int min = dp[index-1];
            if(index%2 ==0){
                min =  Math.min(dp[index/2], dp[index-1]);
                next = dp[index-1] < dp[index/2]? index -1: index/2;
            }
            if(index%3 == 0){
                next = dp[index/3] < min? index/3 : next;
            }
            index = next;
        }

        bw.flush();
    }

}



