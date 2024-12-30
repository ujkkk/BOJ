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

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 문제의 수
        int M = Integer.parseInt(st.nextToken());   // 문제에 대한 정보 개수

        int [] inDegree = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Integer>();
        }

        // 간선 정보 입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            inDegree[b]++;
        }

        /* 문제풀기 시작 */
        // 우선순위가 없는 문제 큐에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean [] check = new boolean[N+1];
        for(int i=1; i<= N; i++){
            if(inDegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            // 더 쉬운 문제를 꺼내기
            int cur = pq.poll();

            if(check[cur]){
                continue;
            }
            check[cur] = true;
            bw.write(cur+" ");

            for(int next : graph[cur]){
                inDegree[next]--;

                // 방문하지 않고, 우선순위가 없으면 큐에 삽입
                if(!check[next] && inDegree[next] == 0){
                    pq.add(next);
                }
            }

        }

        bw.flush();

        bw.close();

    }
}
