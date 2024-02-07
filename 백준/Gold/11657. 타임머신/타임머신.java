import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

/*
    위상 정렬 이용 : 선후 관계가 있고, 사이클이 없으면서 순서를 알아야 하기 때문ㅇ
    입력이 '[시간] [선 건물1] [선 건물2] ... [-1]' 이 주어지기에 구분 필요
    건물은 동시에 지을 수 있기에 직전 건물까지 걸린 시간을 알고 있어야 함
 */
public class Main {
    static BufferedWriter bw;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 도시의 개수
        int N = Integer.parseInt(st.nextToken());
        // 버스 노선의 개수
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();

        // 버스 노선만큼 간선을 입력 받음 ['start' 'end' 'weight']
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, weight));
        }

        long[] result = bellman_ford(N, 1, edges);

        if(N==1){
            bw.write(result[1] +"\n" );
        }
        else if(result.length == 1){
            // 음수 사이클이 있을 떄
            bw.write("-1");
        }
        else{
            for(int i=2; i<result.length; i++){
                if(result[i] == Long.MAX_VALUE)
                    bw.write("-1\n" );
                else
                    bw.write(result[i]+"\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static long[] bellman_ford(int N, int start, ArrayList<Edge> edges){
        // start부터 각 노드까지의 최단거리를 담을 배열 생성
        long[] result = new long[N+1];
        // 중요 : 가장 큰 수(무한대)로 초기화
        Arrays.fill(result, Long.MAX_VALUE);

        // start 노드의 최단거리는 0
        result[start] = 0;

        // 반복 횟수를 N-1번으로 설정.
        // 제일 멀리 떨어진 노드들도 N-1개의 간선으로 무조건 갈 수 있기 때문
        for(int i=1; i<= N; i++){
            for(Edge edge : edges){
                // 한 번도 방문하지 않은 노드로는 최단거리를 찾을 수 없음
                if(result[edge.start] == Long.MAX_VALUE)
                    continue;
                // 루프가 반복될 수록 각 노드의 경로 값이 작은 쪽으로 바뀜
                // 연결된 노드들도 작아질 가능성이 생기므로 확인 후 작아지면 갱신
                if(result[edge.end] > result[edge.start] + edge.weight){
                    // N-1번으로 모든 간선을 갈 수있는데 N번 째에서 업그레이드가 된다는 것은
                    // 음수 사이클이 존재한다는 뜻
                    if(i == N){
                        // 음수 사이클 발생
                        return new long[]{-1};
                    }
                    result[edge.end] = result[edge.start] + edge.weight;
                }
            }
        }
        return result;

    }
}

class Edge{
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}