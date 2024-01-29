import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw;
    static BufferedReader br;
    static int K, X, N,M;
    static int [] distance;
    static TreeSet result;
    static ArrayList<Integer>[] graph;
    static boolean isfind = false;

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
        
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N+1];
        visited[X] = true;
        dfs(X, visited, 0);


        for(int i=1; i<N+1; i++){
            if(distance[i] == K){
                isfind = true;
                bw.write(i+"\n");
            }
        }
        if(!isfind)
            bw.write("-1");
        
        bw.flush();
        br.close();
        bw.close();

    }

    public static void dfs(int start, boolean[] visited, int depth){
        distance[start] = depth;
        if(depth == K){
            return;
        }

        for(int child : graph[start]){
            if(!visited[child] && distance[child] > depth+1){
                visited[child]= true;
                dfs(child, visited, depth+1);
                visited[child] = false;
            }
        }
    }

}