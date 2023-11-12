
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String [] data = br.readLine().split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);

            int [][]nums = new int[N+1][N+1];
            int [][] sum = new int[N+1][N+1];

            // 숫자 데이터 입력받
            for(int i=1; i<=N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    nums[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 구간 합 구하기
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + nums[i][j];
                }
            }

            int max = Integer.MIN_VALUE;
            for(int i=M; i<=N; i++){
                for(int j=M; j<=N; j++){
                    int partSum = sum[i][j] - sum[i-M][j] - sum[i][j-M] + sum[i-M][j-M];
                    max = Math.max(partSum, max);
                }
            }
            bw.write("#" + test_case + " " + max +"\n");
        }

        bw.flush();

        bw.close();
        br.close();

    }
}