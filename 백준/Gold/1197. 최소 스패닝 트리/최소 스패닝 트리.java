import java.io.*;
import java.util.*;


public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static ArrayList<Edge> edges;
    static int [] parent ;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수
        int V = Integer.parseInt(st.nextToken());
        // 간선의 개수
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        // 유니온 파인트 배열
        parent = new int[V+1];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        bw.write(MST(edges, V)+"");

        bw.flush();
        br.close();
        bw.close();

    }


    public static int find(int a){
        if(parent[a] == a)
            return a;

        a = find(parent[a]);
        return a;
    }

    public static int MST(PriorityQueue<Edge> edges, int N){
        int count = 0;
        int result = 0;

        while(count < N-1){
            Edge cur = edges.poll();
            int a = find(cur.start);
            int b = find(cur.end);
            if(a != b){
                result += cur.weight;
                parent[b] = a;
                count++;
            }

        }
        return result;
    }
}
class Edge{
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight= weight;
    }
}

