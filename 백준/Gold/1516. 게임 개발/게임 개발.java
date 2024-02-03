
import java.io.*;
import java.util.*;

/*
    위상 정렬 이용 : 선후 관계가 있고, 사이클이 없으면서 순서를 알아야 하기 때문ㅇ
    입력이 '[시간] [선 건물1] [선 건물2] ... [-1]' 이 주어지기에 구분 필요
    건물은 동시에 지을 수 있기에 직전 건물까지 걸린 시간을 알고 있어야 함
    출력 : 각 건물들의 건물들이 완성되기까지 걸린 최소 시간
 */
public class Main {
    static BufferedWriter bw;
    static BufferedReader br;
    static ArrayList<Integer> [] graph;
    static int [] inDegree;
    static int [] time;
    static int N;


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        inDegree = new int[N+1];
        time = new int[N+1];

        for(int i=0; i< graph.length; i++)
            graph[i] = new ArrayList<Integer>();

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 건물짓는데 걸리는 시간
            time[i] = Integer.parseInt(st.nextToken());
            int parent;
            while((parent = Integer.parseInt(st.nextToken())) != -1){
                graph[parent].add(i);
                inDegree[i]++;
            }
        }
        int [] result =  topologicalSorting();

        for(int i=1; i<=N; i++){
            bw.write(result[i] + time[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    public static int [] topologicalSorting(){
        int [] result = new int[N+1];
        Queue<Integer> que = new LinkedList();
        for(int i=1; i< inDegree.length; i++){
            if(inDegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()) {
            int cur = que.poll();
            for (int child : graph[cur]) {
                inDegree[child]--;
                // 업데이트
                result[child] = Math.max(result[cur] + time[cur], result[child]);
                // 만족시켜 할 선후관계가 없기에 삽입
                if (inDegree[child] == 0) {
                    // 더 짧은 시간이면 갱신
                    que.add(child);
                }
            }
        }
        return result;
    }


}
