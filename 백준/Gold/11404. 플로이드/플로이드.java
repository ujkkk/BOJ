import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 도시의 개수
        int N = Integer.parseInt(br.readLine());
        // 버스의 개수
        int M = Integer.parseInt(br.readLine());

        // 인접행렬로 최단거리 표현
        int [][] graph = new int[N+1][N+1];
        // 가장 큰 값으로 초기화
        for(int i=0; i<graph.length; i++)
            for(int j=0; j<=N; j++){
                if(i==j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 100_000_01;
            }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 같은 간선이 여러 번 나올 수 있으니 더 작은 값으로 갱신
            if(graph[a][b] > cost) graph[a][b] = cost;
        }

        // 플로이드 알샬 알고리즘 사용
        for(int k=1; k<=N; k++){
            for(int i =1; i<=N; i++)
                for(int j=1; j<=N; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(graph[i][j] == 100_000_01)
                    bw.write(0+" ");
                else
                    bw.write(graph[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }




}

