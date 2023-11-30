import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main
{

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int energy[][] = new int[N][2];
        int dp [] = new int[N+3];

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken());
            energy[i][1] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = energy[0][0];

        for(int i=2; i<N; i++){
            dp[i] = Math.min(dp[i-1] + energy[i-1][0] , dp[i-2] +energy[i-2][1]);
        }

//        // 가장 크게 차이 나는 구간 찾기
//        int max_index = 0;
//        int max = 0;
//        for(int i=3; i<N; i++){
//            if(max < dp[i]-dp[i-3]){
//                max = dp[i]-dp[i-3];
//                max_index = i;
//            }
//        }
        int min = dp[N-1];
        for(int max_index=3; max_index<N; max_index++){
            int [] tempDp = dp.clone();
            if(dp[max_index]> dp[max_index-3]+ K){

                // 매우 큰 점프 사용
                tempDp[max_index] = tempDp[max_index-3]+ K;
                for(int i=max_index+1; i<N; i++){
                    tempDp[i] = Math.min(tempDp[i-1] + energy[i-1][0], tempDp[i-2] +energy[i-2][1]);
                }
            }
            min = Math.min(min, tempDp[N-1]);

        }


        bw.write(min+"\n");
        bw.flush();

        bw.close();
        br.close();

    }

}

