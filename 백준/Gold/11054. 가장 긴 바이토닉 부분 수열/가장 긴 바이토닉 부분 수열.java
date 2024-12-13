import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int [] nums = new int[N];
        int [] dp1 = new int[N];
        int [] dp2 = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp1[0] = 1;
        for(int i=1; i<N; i++){

            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp1[i] = Math.max(dp1[j]+1, dp1[i]);
                }
            }
            if(dp1[i] == 0){
                dp1[i] = 1;
            }
        }

        dp2[N-1] = 1;
        for(int i=N-2; i>=0; i--){
            for(int j=i+1; j<N; j++){
                if(nums[j] < nums[i]){
                    dp2[i] = Math.max(dp2[j]+1, dp2[i]);
                }
            }
            if(dp2[i] == 0){
                dp2[i] = 1;
            }
        }

        // 최대값 찾기
        int max = 0;
        for(int i=0; i<N; i++){
            max = Math.max(max, dp1[i] + dp2[i] -1);
        }

        System.out.println(max);
    }
}

