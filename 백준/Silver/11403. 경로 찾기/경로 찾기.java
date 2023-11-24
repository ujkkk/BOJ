import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> [] graph;
    static int [][] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        result = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int row=1; row<=N; row++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int col=1; col<=N; col++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1)
                    graph[row].add(col);
            }
        }

        for(int row =1; row<=N; row++){
            if(graph[row].size() > 0){
                boolean [] isVisited = new boolean[N+1];
                BFS(isVisited, row);
            }

        }

        for(int row=1; row<=N; row++) {
            for (int col = 1; col <= N; col++) {
                bw.write(result[row][col] +" ");
            }
            bw.write("\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    static void BFS(boolean [] isVisited, int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int current = que.poll();

            for(int next : graph[current]){
                if(!isVisited[next]){
                    que.add(next);
                    isVisited[next] = true;
                    result[start][next] = 1;
                }
            }
        }

    }
}
