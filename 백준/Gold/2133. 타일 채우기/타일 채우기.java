import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        long dp [] = new long[N+1];

        if(N % 2 != 0){
            System.out.println("0");
            return;
        }

        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i<=N; i+=2){
            dp[i] = dp[i-2]*3;
            // 4부터 특별 경우가 2가지 씩 나온다
            // 근데 특별 경우가 2 단위로 계속 2개씩 추가된다.
            // 그래서 j를 빼서 현재 경우에 j블록을 넣는 경우를 생각한다
            // 구성된 4블록에서 4블록을 넣기, 구성된 2블록에서 6블록을 넣기...
            for(int j=i-4; j>=0; j-=2){
                dp[i] += dp[j]*2;
            }
        }

        System.out.println(dp[N]);
    }
}
