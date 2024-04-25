import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static List<Integer>[] graph;
    public static int [][] graphMap;
    public static int [][] dp;
    public static int N, K, M;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마지막 도착 정점
        M = Integer.parseInt(st.nextToken()); // 최대 M개
        K = Integer.parseInt(st.nextToken()); // 개설된 항로의 개수

        graph = new ArrayList [N+1];
        graphMap = new int[N+1][N+1];
        dp = new int[N+1][M+1];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(v1 > v2)
                continue;

            if(graphMap[v1][v2] < cost)
                graphMap[v1][v2] = cost;
        }

        for(int i=1; i<= N; i++){
            for(int j=i+1; j<=N; j++){
                if(graphMap[i][j] == 0)
                    continue;
                graph[i].add(j);
            }
        }
        BFS();

        int max = 0;
        for(int i=1; i<=M; i++){

            max = Math.max(max, dp[N][i]);

        }
        bw.write( max+"\n");
        bw.flush();
    }

    public static void BFS(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 1));

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.count >= M)
                continue;

            for(int next : graph[cur.vertex]){
                int cost = graphMap[cur.vertex][next];

                if(dp[cur.vertex][cur.count] + cost > dp[next][cur.count+1]){
                    dp[next][cur.count+1] = Math.max(dp[next][cur.count+1],
                            dp[cur.vertex][cur.count] + cost);
                    que.add(new Node(next, cur.count +1));
                }

            }
        }

    }


}

class Node{
    int vertex;
    int count;

    public Node(int vertex, int count) {
        this.vertex = vertex;
        this.count = count;
    }
}