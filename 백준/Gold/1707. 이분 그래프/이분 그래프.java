
import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static ArrayList<Integer>[] graph;
    static int [] color;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());
        for(int t=0; t<K; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            color = new int[V+1];
            // 초기화
            for(int i=1; i<=V; i++){
                graph[i] = new ArrayList<>();
                color[i] = -1;
            }

            // 간선 입력
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                graph[n].add(m);
                graph[m].add(n);
            }

            // BFS 탐색으로 색깔 넣어주기
            int i;
            for( i=1; i<=V; i++){
                // 해당 정점을 방문하지 않았다면 해당 정점을 포함하는 싸이클 탐색 시작
                if(color[i] == -1){
                    // 한 싸이클에 대해서 색상 지정
                    if(!BFS(i,color))
                        break;

                }
            }
            if(i == V+1){
                bw.write("YES\n");
            } else{
                bw.write("NO\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static boolean BFS(int start, int [] color){
        color[start] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int cur = que.poll();
            int nextColor = color[cur] == 0? 1 : 0;

            for(int child : graph[cur]){
                if(color[child] == -1){
                    color[child] = nextColor;
                    que.add(child);
                } else{
                    if(color[cur] == color[child])
                        return false;
                }
            }
        }
        return true;
    }
}


