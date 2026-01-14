import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
       int T = Integer.parseInt(br.readLine());
       StringTokenizer st;

        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());   // 정점의 개수
            int E = Integer.parseInt(st.nextToken());   // 간선의 개수

            ArrayList[] graph = new ArrayList[V+1];
            for(int i=0; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                // 양방향, 근데 중복 간선이 나올 수도 있을 듯. 근데 있어도 상관없을 듯
                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            boolean [] isVisited = new boolean[V+1];
            boolean isEnd = false;
            for(int i=1; i<=V; i++){
                if(isVisited[i]) continue;
                if(!isBipartiteGraph(V, graph, i, isVisited)){
                    isEnd = true;
                    break;
                }
            }
            if(!isEnd)
                sb.append("YES\n");
            else{
                sb.append("NO\n");
            }

        }
        System.out.println(sb);
    }


    public static boolean isBipartiteGraph(int V, ArrayList<Integer>[] graph, int start, boolean [] isVisited){
        boolean [] isBlack = new boolean[V+1]; // 블랙 앤 화이트 그룹으로 나눌거임

        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        isVisited[start] = true;
        isBlack[start] = true;

        while(!que.isEmpty()){
            int cur = que.poll();

            for(int next: graph[cur]){
                if(isVisited[next]){
                    // 이미 그룹이 정해진 노드인데, 인접노드간 색이 같을 떄
                    if(isBlack[cur] == isBlack[next]){
//                        System.out.println(String.format("[%d] 방문 : %d와 겹침", cur, next));
                        return false;
                    }
                    continue;
                }

                isVisited[next] = true;
                isBlack[next] = !isBlack[cur];
                que.add(next);
//                System.out.println(String.format("[%d] 방문 : %s", next, isBlack[next]?"BLACK":"WHITE"));
            }
        }
        return true;
    }

}