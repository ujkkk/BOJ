import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static ArrayList<Integer>[] tree;
    public static int [][] dp;
    public static int [] cost;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cost = new int[N+1];
        tree = new ArrayList[N+1];
        dp = new int[N+1][2];

        for(int i=1; i<=N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[v].add(w);
            tree[w].add(v);
        }

        int start = 0;
        for(int i=1; i<=N; i++){
            if(tree[i].size() == 1){
                start = i;
            }
            dp[i][1] = cost[i];
        }

        getMax(start, start, new boolean[N+1]);
        System.out.println(Math.max(dp[start][0], dp[start][1]));
    }

    public static void getMax(int start, int n, boolean [] isVisited){

        isVisited[n] = true;
        // 말단 노드
        if(n != start && tree[n].size() == 1){
            dp[n][0] = 0;
            dp[n][1] = cost[n];
            return;
        }


        for(int next : tree[n]){
            if(isVisited[next]){
                continue;
            }

            getMax(start, next, isVisited);
            // 선택 하는 경우
            dp[n][1] += dp[next][0];
            dp[n][0] += Math.max(dp[next][1] , dp[next][0]);
        }


    }

}

