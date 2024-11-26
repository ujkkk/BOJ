import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        // 다익스트라
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] nodes = new ArrayList[N+1];
        for(int i=0; i<nodes.length; i++){
            nodes[i] = new ArrayList<Node>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodes[v].add(new Node(w, cost));
            nodes[w].add(new Node(v, cost));
        }

        int [] dis = new int[N+1];
        boolean [] isVisited = new boolean[N+1];
        Arrays.fill(dis, 60_000_000);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0));
        dis[1] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.w == N){
                System.out.println(cur.cost);
                return;
            }

            if(isVisited[cur.w]){
                continue;
            }
            isVisited[cur.w] = true;


            for(Node next: nodes[cur.w]){
                if(isVisited[next.w]){
                    continue;
                }
                if(dis[next.w] > dis[cur.w] + next.cost){
                    pq.add(new Node(next.w, dis[cur.w] + next.cost));
                    dis[next.w] = dis[cur.w] + next.cost;
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int w;
    int cost;

    public Node(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
