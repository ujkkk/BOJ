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
        int [] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] : 수열 i번째 요수부터 j번째 요소까지는 펠린드롬?
        boolean [][] dp = new boolean[N+1][N+1];

        // dp 초기화
        for(int i=0; i<N; i++){
            dp[i][i] = true;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                if(nums[i] != nums[j]){
                    continue;
                }
                if(i-j >1 ){
                    dp[i][j] = dp[i-1][j+1]? true: false;
                }
                else if (i - j == 1) {
                    dp[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(dp[b-1][a-1]? "1\n" : "0\n");
        }
        bw.flush();
    }





}

