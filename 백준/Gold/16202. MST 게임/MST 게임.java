import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M, K;
    public static PriorityQueue<Edge> que;
    public static List<Edge> edges;
    public static int [] parent;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 그래프 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 그래프 간선의 개수
        K = Integer.parseInt(st.nextToken());   // 턴의 수
        parent = new int[1001];

        // 간선 정보 입력
        edges = new ArrayList<Edge>();
        que = new PriorityQueue<>();
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a,b,i));
        }

        boolean isEnd = false;
        for(int k=0; k<K; k++){
            if(isEnd){ // 앞 라운드에서 0이 나왔으면
                bw.write("0 ");
                continue;
            }

            createQue();
            // parent 배열 자기 자신으로 초기화
            for(int i=0; i<parent.length; i++){
                parent[i] = i;
            }
            for(int i=0; i<k; i++)
                que.poll();

            int sum = MST();
            if(sum == 0)
                isEnd = true;
            bw.write(sum +" ");
        }
        bw.flush();

    }
    public static PriorityQueue<Edge> createQue(){
        que = new PriorityQueue<>();
        for(Edge edge : edges){
            que.add(edge);
        }
        return que;
    }

    public static int MST(){
        int count = 0;
        int sum = 0;
        while(!que.isEmpty()){
            if(count == N-1)
                return sum;
            Edge cur = que.poll();

            // 같은 그룹에 속하는지 확인
            int a = find(cur.a);
            int b = find(cur.b);

            if(a!=b){
                count++;
                sum += cur.w;   // MST를 이루는 비용 증가

                // 그룹 연결
                parent[b] = a;
            }
        }
        return count == N-1? sum : 0;
    }

    public static int find(int a){
        if(parent[a] == a)
            return a;

        return find(parent[a]);
    }

}
class Edge implements Comparable<Edge>{
    int a;
    int b;
    int w;

    public Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        // 가중치가 낮은 것을 우선순위로
        return this.w - o.w;
    }
}

