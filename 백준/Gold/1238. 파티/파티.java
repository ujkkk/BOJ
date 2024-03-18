import java.lang.*;
import java.io.*;
import java.util.*;

/*
    A -> X + X -> A == 가장 오래 걸리는 학생 (최단 길로 왔을 때)

 */
class Main {

    public static int N;
    public static boolean [] isVisited;
    public static ArrayList<Node>[] tress_O;
    public static ArrayList<Node>[] tress_R;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        tress_O = new ArrayList[N+1]; // 정뱡항 간선 저장
        tress_R = new ArrayList[N+1]; // 역방향 간선 저장

        for(int i=0; i< tress_O.length; i++){
            tress_O[i] = new ArrayList<>();
            tress_R[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            tress_O[u].add(new Node(v, time));
            tress_R[v].add(new Node(u, time));
        }

        // 역방향으로 X부터 모든 정점까지의 최단거리 구하기 (특정노드 A에서 X로 가는 최단거리)
        int dist1 [] = dikstra(X, tress_R);

        // 정방향으로 X부터 모든 정점까지의 최단거리 구하기
        int dist2 [] = dikstra(X, tress_O);

        int max = 0;
        for(int i=1; i< dist1.length; i++){
            max = Math.max(max, dist1[i] + dist2[i]);
        }
        System.out.println(max);


    }

    public static int [] dikstra(int start, ArrayList<Node>[] tree){
        int dist [] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> que = new PriorityQueue<>();

        isVisited = new boolean[N+1];
        que.add(new Node(start, 0));
        dist[start] = 0;

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(isVisited[cur.value])
                continue;

            isVisited[cur.value] = true;

            for(Node next : tree[cur.value]){
                if(dist[next.value] > dist[cur.value] + next.time){
                    dist[next.value] = dist[cur.value] + next.time;
                    que.add(new Node(next.value, dist[next.value]));
                }
            }
        }

        return dist;
    }

}

class Node implements Comparable<Node>{
    int value;
    int time;

    public Node(int value, int time){
        this.value = value;
        this.time = time;
    }

    @Override
    public int compareTo(Node o){
        return time - o.time;
    }
}



