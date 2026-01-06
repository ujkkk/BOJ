import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] dr = {-1, 0, 1, 0};
    static int [] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int T = 0;
        while(true){
            T++;
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int [][] map = new int[N][N];
            int [][] curCost = new int[N][N];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    curCost[i][j] = 1000000;
                }
            }

            PriorityQueue<Node> que = new PriorityQueue<>();
            boolean [][] isVisited = new boolean[N][N];

            que.add(new Node(0, 0, map[0][0]));

            curCost[0][0] = map[0][0];

            while(!que.isEmpty()){
                Node cur = que.poll();
               // System.out.println(cur);
                if(cur.r == N-1 && cur.c == N-1){
                    break;
                }
                // 꺼내진 순간에 방문 처리 해야함
                isVisited[cur.r][cur.c] = true;

                for(int i=0; i<4; i++){
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if(nr <0 || nr >=N || nc <0 || nc >= N){
                        continue;
                    }
                    if(isVisited[nr][nc]){
                        continue;
                    }

                    int nextCost = curCost[cur.r][cur.c] + map[nr][nc];
                    if(curCost[nr][nc] > nextCost){
                        que.add(new Node(nr, nc, nextCost));
                        curCost[nr][nc] = nextCost;
                    }
                }
            }
            sb.append("Problem ").append(T).append(": " ).append(curCost[N-1][N-1]+"\n");
        }
        System.out.println(sb.toString());
    }
}

class Node implements Comparable<Node>{
    int r;
    int c;
    int cost;

    public Node(int r, int c, int cost) {
        this.r = r;
        this.c = c;
        this.cost = cost;
    }

    public int compareTo(Node o){
        return  this.cost - o.cost;
    }

    @Override
    public String toString(){
        return this.r +", " + this.c + " 방문. cost: " + cost;
    }

}