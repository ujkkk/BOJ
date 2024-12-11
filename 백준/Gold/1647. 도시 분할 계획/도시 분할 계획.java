import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 마을의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
            graph[w].add(new Node(v, cost));
        }

        boolean [] isVisited = new boolean[N+1];
        bw.write(prim(graph, isVisited) +"\n");
        bw.flush();
    }

    private static int prim(ArrayList<Node>[] graph, boolean [] isVisited){

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 0));
        int dist = 0;
        int max = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(isVisited[cur.n]){
                continue;
            }

            isVisited[cur.n] = true;

            max = Math.max(max, cur.cost);
            dist += cur.cost;

            for(Node next : graph[cur.n]){
                if(isVisited[next.n]){
                    continue;
                }
                q.offer(new Node(next.n,  next.cost));
            }
        }
        return dist - max;
    }
}

class Node implements Comparable<Node>{
    int n;
    int cost;

    public Node(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}