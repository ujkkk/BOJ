import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static int K, X, N,M;
    static List<Integer> ans;
    static int [] distance;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        N = Integer.parseInt(st.nextToken());
        // 도로의 개수
        M = Integer.parseInt(st.nextToken());
        // 거리 정보
        K = Integer.parseInt(st.nextToken());
        // 출발 도시의 번호
        X = Integer.parseInt(st.nextToken());

        // 그래프 - 인접 배열
        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<Integer>();

        // 연결 도로 입력 받기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            // 단방향 간선 추가
            graph[n1].add(n2);
        }

        ans = new ArrayList<>();
        distance = new int[N+1];
        Arrays.fill(distance, -1);
        
        bfs(X);

        if(ans.size() == 0){
            bw.write("-1");
        } else{
            Collections.sort(ans);
            for(int node : ans){
                bw.write(node +"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();

    }
    public static void bfs(int start){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        distance[start] = 0;

        while(!que.isEmpty()){
            int cur = que.poll();
            if(distance[cur] > K)
                continue;
            if(distance[cur] == K){
                ans.add(cur);
                continue;
            }

            for(int child : graph[cur]){
                // 방문을 하지 않았다면
                if(distance[child] == -1){
                    distance[child] = distance[cur] +1;
                    que.add(child);
                }
            }

        }
    }

}