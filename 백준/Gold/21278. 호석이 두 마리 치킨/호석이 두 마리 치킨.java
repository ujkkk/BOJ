import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
    100개의 노드 중 2개 고르기 -> 100C2 = 약 4600
    다익스트라 ElogV *2 = 100log4600 X2 = 2400
    => 11,040,000 약 천만
 */
public class Main {

    public static int disSum = Integer.MAX_VALUE;
    public static int[] result = new int[2];
    public static int N, M;
    public static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i< graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력받기
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        int [] dis;
        for(int i=1; i<= N-1; i++){
            dis = new int[N+1];
            Arrays.fill(dis, Integer.MAX_VALUE);

            for(int j=i+1; j<=N; j++){
                // i,j 위치에 치킨집을 설치했다고 가정
                dis[i] = dis[j] = 0;
                int temp = BFS(i,j, dis);

                if(disSum > temp){
                    result[0] = i;
                    result[1] = j;
                    disSum = temp;
                }
            }
        }
        bw.write(result[0]+" " + result[1]+" ");
        bw.write(disSum*2 + "");
        bw.flush();
    }

    public static int BFS(int s1, int s2, int [] dis){
        int sum = 0;
        boolean [] isVisited = new boolean[N+1];
        Queue<Integer> que = new LinkedList<>();

        que.add(s1);
        que.add(s2);
        isVisited[s1] = isVisited[s2] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            for(int next : graph[cur]){
                if(!isVisited[next]){
                    que.add(next);
                    dis[next] = dis[cur]+1;
                    sum += dis[next];
                    isVisited[next] = true;
                }
            }
        }
        return sum;
    }

}





