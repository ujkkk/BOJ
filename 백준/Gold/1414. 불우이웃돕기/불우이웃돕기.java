
import java.io.*;

/*
 * 모든 점 최소비용으로 탐색 -> 최소 비용 트리
 * 엣지 리스트 필요 -> 입력정보로 인접행렬을 만든 후,탐색해서 리스트 생성
 */
import java.util.*;

public class Main {

    public static BufferedWriter bw;
    public static BufferedReader br;

    public static int [] parent;


    static int [] ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int [][]map = new int[N][N];
        int len = 0;

        for(int i=0; i<N; i++) {
            String aline = br.readLine();
            for(int j=0; j<N; j++) {

                int n = aline.charAt(j) - 'a' +1;
                // 음수라면 대문자이거나 0
                if(n < 0) {
                    if(n == -48)
                        continue;
                    // 대문자
                    n += 58;
                }
                map[i][j] = n;
                len+= n;

            }
        }

        PriorityQueue<Edge> que = new PriorityQueue<Edge>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.cost - o2.cost;
            };
        });

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i==j || map[i][j] == 0) continue;

                que.add(new Edge(i,j, map[i][j]));

            }
        }

        // 최소 신장 트리 알고리즘 시작
        int ans = 0;
        int count =0;
        parent = new int[N];
        for(int i=0; i<parent.length; i++)
            parent[i] = i;

        while(!que.isEmpty()) {
            Edge cur = que.poll();
            int a = find(cur.start);
            int b = find(cur.end);

            if(a != b) {
                union(a,b);
                ans += cur.cost;
                count++;
            }
        }

        if(count == N-1) {
            bw.write(len - ans +"");
        }else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b)
            return;

        parent[b]= a;
    }

    public static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}

class Edge {
    int start;
    int end;
    int cost;

    Edge(int start, int end, int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }


}

