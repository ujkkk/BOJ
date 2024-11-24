import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 지름길의 개수
        int D = Integer.parseInt(st.nextToken());   // 지나야할 고속도로 길이

        List<Load> loads = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            loads.add(new Load(start, end, cost));
        }

        int [] dp = new int[D+1];
        
        for(int i=0; i<=D; i++){
            if(i != 0){
                dp[i] =  dp[i-1] +1;
            }
            for(Load load : loads){
                if(load.end == i){
                    // 더 작은 값으로 갱신
                    dp[load.end] = Math.min(dp[load.start] + load.dis, dp[load.end]);
                }
            }
        }
        System.out.println(dp[D]);
    }
 }

 class Load {
    int start;
    int end;
    int dis;

     public Load(int start, int end, int dis) {
         this.start = start;
         this.end = end;
         this.dis = dis;
     }

 }

