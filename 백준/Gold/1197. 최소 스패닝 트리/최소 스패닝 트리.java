import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int V;
    public static  List<Edge>[] edges;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList[V+1];

        for(int i=0; i<=V; i++){
            edges[i] = new ArrayList<>();
        }

        // 그래프 완성
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[v1].add(new Edge(v2, cost));
            edges[v2].add(new Edge(v1, cost));
        }

        System.out.println(MST());
    }

    private static long MST(){
        long cost = 0;
        int count = 0;

        PriorityQueue<Edge> que = new PriorityQueue<>();
        boolean [] isVisited = new boolean[V+1];

        isVisited[1] = true;
        count++;
        for(Edge next: edges[1]){
            que.add(new Edge(next.v, next.cost));
        }

        while(!que.isEmpty()){
            Edge cur = que.poll();

            if(isVisited[cur.v]){
                continue;
            }

            isVisited[cur.v] = true;
            cost += cur.cost;
            count++;

            if(count == V){
                break;
            }

            for(Edge next: edges[cur.v]){
                if(isVisited[next.v]){
                    continue;
                }
                que.add(new Edge(next.v, next.cost));
            }
        }

        return cost;
    }


}

class Edge implements Comparable<Edge>{
    int v;
    int cost;

    public Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost;
    }
}

