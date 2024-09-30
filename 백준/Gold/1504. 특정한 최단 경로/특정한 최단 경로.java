import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static ArrayList<Node>[] tree;
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.
    static final int INF = 200000000;
    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        check = new boolean[N + 1];

        tree = new ArrayList[N+1];
        for(int i=0; i<tree.length; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v, dis));
            tree[v].add(new Node(u, dis));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        if(res1 >=  INF && res2  >= INF ){
            bw.write(-1+"\n");
        }
        else 
            bw.write(Math.min(res1,res2) +"\n");
        
        bw.flush();
    }

    public static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        dist[start] = 0;
        que.add(new Node(start, 0));

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.n == end){
                return cur.dis;
            }
            if(check[cur.n]){
                continue;
            }
            check[cur.n] = true;

            for(Node next: tree[cur.n]) {
                if (dist[next.n] > dist[cur.n] + next.dis) {
                    dist[next.n] = dist[cur.n] + next.dis;
                    que.add(new Node(next.n, dist[next.n]));
                }
            }
        }
        return dist[end];
    }

}


class Node implements Comparable {
    int n;
    int dis;

    public Node(int n, int dis) {
        this.n = n;
        this.dis = dis;
    }

    @Override
    public int compareTo(Object o) {
        Node node = (Node)o;

        return this.dis - node.dis;
    }
}
