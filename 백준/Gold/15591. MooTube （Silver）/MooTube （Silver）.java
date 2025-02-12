import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Node>[] tree;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[u].add(new Node(v, cost));
            tree[v].add(new Node(u, cost));
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] check = new boolean[N+1];
            check[v] = true;
            bw.write( bfs(v, k, Integer.MAX_VALUE, check, 0)+"\n");
        }
        bw.flush();
    }

    static int bfs(int n, int k, int curK, boolean[] check, int count){
        //System.out.println(n + " 방문 " + ": " + count);
        for(Node next : tree[n]){
            if(check[next.n]){
                continue;
            }
            check[next.n] = true;
            // 추천 동영상에 포함
            if(Math.min(curK, next.cost) >= k){
                count++;
            }
            count = bfs(next.n, k, Math.min(curK, next.cost), check, count);
        }
        return count;
    }
}

class Node{
    int n;
    int cost;

    public Node(int n, int cost) {
        this.n = n;
        this.cost = cost;
    }
}