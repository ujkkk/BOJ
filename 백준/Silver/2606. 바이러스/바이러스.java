
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList();
        }

        // 네트워크 연결
        int M = Integer.parseInt(br.readLine());
        for(int m=0; m<M; m++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(w);
            graph[w].add(v);
        }

        // 탐색
        System.out.println(bfs());
    }

    static int bfs(){
        boolean [] isVisited = new boolean[N+1];
        Queue<Integer> que = new ArrayDeque<>();
        int cnt = 0;

        que.add(1);
        isVisited[1] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            cnt++;

            for(int next : graph[cur]){
                if(isVisited[next]) continue;

                isVisited[next] = true;
                que.add(next);
            }
        }
        return cnt-1;
    }

}